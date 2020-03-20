package dev.anksandabhi.sparkjob1;

import dev.anksandabhi.constants.Constants;
import org.apache.spark.SparkConf;

public class SparkJob1Config {

    public static SparkConf getSparkConfiguration()
    {
        SparkConf sparkConf=new SparkConf().setAppName(Constants.APP_NAME);
        return sparkConf;
    }
}
