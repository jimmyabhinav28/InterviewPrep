package dev.anksandabhi.sparkjob1;

import com.amazonaws.auth.AWSCredentials;
import dev.anksandabhi.AwsUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

import java.util.Arrays;
import java.util.Iterator;

public class SparkWordCount {

    private final static Logger logger = LogManager.getLogger(SparkWordCount.class);

//    System.out.println();
    public static void getWordCount(String s3InputFile)
    {
        AWSCredentials awsCredentials= AwsUtils.getAwsCredentialsFromMyLocalMachine();
        System.out.println("access key id"+awsCredentials.getAWSAccessKeyId());
        System.out.println("access secret key"+awsCredentials.getAWSSecretKey());
        JavaSparkContext javaSparkContext=SparkConfiguration.getSparkJavContextForS3(awsCredentials,"wc");
        System.out.println("Fetching input data from S3 bucket");
        JavaRDD<String> s3InputRDD = javaSparkContext.textFile(s3InputFile);

        System.out.println(String.format("Total number of lines to process: %d", s3InputRDD.count()));

        System.out.println("Preparing words RDD");
        JavaRDD<String> words = s3InputRDD.flatMap(new FlatMapFunction<String, String>() {
            private static final long serialVersionUID = 1L;

            public Iterator<String> call(String x) {
                return Arrays.asList(x.split(" ")).iterator();
            }
        });

        logger.info(String.format("Total words : %d", words.count()));
        logger.trace("Preparing words count RDD");
    }
}
