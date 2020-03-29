package dev.anksandabhi.sparkJob2;


import com.amazonaws.auth.AWSCredentials;
import dev.anksandabhi.AwsUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.apache.spark.sql.functions.col;

public class GenerateCostPriceFromHoldingsSummaryEMRClusterJob {

    private final static Logger logger = LogManager.getLogger(GenerateCostPriceFromHoldingsSummaryEMRClusterJob.class);

    private final static String APP_NAME="HOLDINGS_SUMMARY_TO_COST_PRICE_FILE_USING_SPARK_DATASET";
    private static final String bucketForHoldingsSummaryFile="s3a://holdings.anksandabhi.dev";
    public static String getHoldingsSummaryFilePrefix()
    {
        return "/holdingsSummary/"+getFormattedCurrentDate();
    }

    public static String getHoldingsFileS3AURI()
    {
        return bucketForHoldingsSummaryFile+getHoldingsSummaryFilePrefix();
    }
    private static String getFormattedCurrentDate()
    {
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd_MMM_yyyy");
        return formatter.format(localDate);

    }
    public static void generateCostPriceFileFromHoldingsSummary(String costPriceCSVS3Location) throws InterruptedException {
        logger.info("holdings file must already be present");
        AWSCredentials awsCredentials= AwsUtils.getAwsCredentialsOnCluster();
        SparkSession sparkSession=SparkUtils.getSparkSession(APP_NAME,awsCredentials);
        sparkSession.sparkContext().hadoopConfiguration().set("fs.s3a.aws.credentials.provider", "com.amazonaws.auth.DefaultAWSCredentialsProviderChain");
        Dataset<Row> dataframe= sparkSession.read().option("delimiter","|").option("header", true).csv(getHoldingsFileS3AURI());
        //Asset_Class|As_On_Date|UCC|Purchase_Date|ISIN|Scrip_Name|Quantity|Purchase_Price|Purchase_Value|Market_Price|Market_Value|Unrealized_Gain/Loss_Amount

//        List<Column> columns = Arrays.asList(col("col1"),col("col2"),col("col3"));
//        Dataset<Row> rupeeSeedDataFrame=dataframe.select("ISIN","UCC","Purchase_Price");
//        Dataset<Row> rupeeSeedDataFrame=dataframe.select("ISIN","UCC","Purchase_Price");
        Dataset<Row> rupeeSeedDataFrame=dataframe.select(col("ISIN"),col("UCC"),col("Purchase_Price"));
        exportDataFrameToCSV(rupeeSeedDataFrame,costPriceCSVS3Location);
    }

    private static void exportDataFrameToCSV(Dataset<Row> dataframe,String csvFilePath)
    {
        logger.info("writing csv to "+csvFilePath);
     //coalesece leads to longer times for processing on cluster
        //dataframe.coalesce(1).write().option("sep","|").option("header","true").csv(csvFilePath);
        dataframe.write().option("sep","|").option("header","true").csv(csvFilePath);
        //part files getting generated
        String outputPartFilesPattern=csvFilePath+"/part-*";
        SparkContext sc=dataframe.sparkSession().sparkContext();
        JavaRDD<String> rdd=sc.textFile(outputPartFilesPattern,1).toJavaRDD();//minimum one partition
        rdd.coalesce(1).saveAsTextFile(csvFilePath+"-joined");
    }
}
