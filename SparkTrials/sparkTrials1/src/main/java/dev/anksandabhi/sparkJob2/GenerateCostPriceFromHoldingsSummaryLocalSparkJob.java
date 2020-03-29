package dev.anksandabhi.sparkJob2;


import com.amazonaws.auth.AWSCredentials;
import dev.anksandabhi.AwsUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GenerateCostPriceFromHoldingsSummaryLocalSparkJob {

    private final static Logger logger = LogManager.getLogger(GenerateCostPriceFromHoldingsSummaryLocalSparkJob.class);

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
    public static void generateCostPriceFileFromHoldingsSummary(String holdingsSummaryFileLocation,String costPriceCSVLocation) throws InterruptedException {
        //logger.info("uploading csv file");
        UploadLargeCSVToS3.uploadCSVToS3(holdingsSummaryFileLocation,getHoldingsSummaryFilePrefix(),holdingsSummaryFileLocation);
        logger.info("uploaded csv file");
        AWSCredentials awsCredentials= AwsUtils.getAwsCredentialsFromMyLocalMachine();
        SparkSession sparkSession=SparkUtils.getSparkSession(APP_NAME,awsCredentials);
        Dataset<Row> dataframe= sparkSession.read().option("sep","|").csv(getHoldingsFileS3AURI());
        //Asset_Class|As_On_Date|UCC|Purchase_Date|ISIN|Scrip_Name|Quantity|Purchase_Price|Purchase_Value|Market_Price|Market_Value|Unrealized_Gain/Loss_Amount

        Dataset<Row> rupeeSeedDataFrame=dataframe.select("ISIN","UCC","Purchase_Price");
        exportDataFrameToCSV(rupeeSeedDataFrame,costPriceCSVLocation);
    }

    private static void exportDataFrameToCSV(Dataset<Row> dataframe,String csvFilePath)
    {
        dataframe.write().option("sep","|").option("header","true").csv(csvFilePath);
    }
}
