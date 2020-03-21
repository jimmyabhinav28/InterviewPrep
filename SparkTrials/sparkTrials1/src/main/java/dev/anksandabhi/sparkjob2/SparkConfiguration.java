package dev.anksandabhi.sparkjob2;

import com.amazonaws.auth.AWSCredentials;
import org.apache.hadoop.conf.Configuration;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkConfiguration {

    public static JavaSparkContext getSparkJavContextForS3(AWSCredentials awsCredentials,String applicationName)
    {
        SparkConf conf = new SparkConf().setAppName(applicationName).setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        Configuration configuration = javaSparkContext.hadoopConfiguration();
        //org.apache.hadoop.fs.s3a.BasicAWSCredentialsProvider
        configuration.set("fs.s3a.aws.credentials.provider", "org.apache.hadoop.fs.s3a.SimpleAWSCredentialsProvider");

        configuration.set("fs.s3a.access.key", awsCredentials.getAWSAccessKeyId());
        configuration.set("fs.s3a.secret.key", awsCredentials.getAWSSecretKey());
        return javaSparkContext;
    }
}
