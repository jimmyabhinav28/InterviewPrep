package dev.anksandabhi.sparkJob2;

import com.amazonaws.auth.AWSCredentials;
import org.apache.hadoop.conf.Configuration;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class SparkUtils {

    public static JavaSparkContext getSparkJavaContextForS3(AWSCredentials awsCredentials, String applicationName) {
        SparkConf conf = new SparkConf().setAppName(applicationName).setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        Configuration configuration = javaSparkContext.hadoopConfiguration();
        //org.apache.hadoop.fs.s3a.BasicAWSCredentialsProvider
        configuration.set("fs.s3a.aws.credentials.provider", "org.apache.hadoop.fs.s3a.SimpleAWSCredentialsProvider");

        configuration.set("fs.s3a.access.key", awsCredentials.getAWSAccessKeyId());
        configuration.set("fs.s3a.secret.key", awsCredentials.getAWSSecretKey());
        return javaSparkContext;
    }

    public static SparkSession getSparkSession(String applicationName,AWSCredentials awsCredentials) {
        SparkSession sparkSession=SparkSession.builder().master("yarn").appName(applicationName).getOrCreate();
        sparkSession.sparkContext().hadoopConfiguration().set("fs.s3a.aws.credentials.provider", "org.apache.hadoop.fs.s3a.SimpleAWSCredentialsProvider");
        sparkSession.sparkContext().hadoopConfiguration().set("fs.s3a.secret.key", awsCredentials.getAWSSecretKey());
        return sparkSession;
    }
}
