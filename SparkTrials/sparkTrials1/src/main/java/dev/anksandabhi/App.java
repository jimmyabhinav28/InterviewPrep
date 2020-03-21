package dev.anksandabhi;

import dev.anksandabhi.sparkjob2.SparkWordCount;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //System.out.println( ApplicationProperties.getProperty("aws.access.key.id" ));
        SparkWordCount.getWordCount("s3a://sparktrial1.anksandabhi.dev/sample.txt");
    }
}
