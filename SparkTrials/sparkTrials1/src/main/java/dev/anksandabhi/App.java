package dev.anksandabhi;

import dev.anksandabhi.sparkJob2.GenerateCostPriceFromHoldingsSummaryEMRClusterJob;
import dev.anksandabhi.sparkJob2.UploadLargeCSVToS3;
import dev.anksandabhi.sparkjob1.SparkWordCount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
//    System.out.println("Hello");
//        testMultipartUpload();
        testHoldingsToCPOnEmrCluster();
//        String costPriceFileLocation="/home/tmp/SparkCP.csv";
//        GenerateCostPriceFromHoldingsSummaryLocalSparkJob.generateCostPriceFileFromHoldingsSummary(holdingSummaryFileLocation,costPriceFileLocation);
    }

    private static void testWordCount() {
        SparkWordCount.getWordCount("s3a://sparktrial1.anksandabhi.dev/");
    }

    private static void testMultipartUpload() throws InterruptedException {
        String holdingSummaryFileLocation = "/tmp/BullfinchFilesLoadTest/Holding_Sumry.csv";
        String prefix = "holdingsSummary/" + getFormattedCurrentDate() + "/Holding_Sumry.csv";
        UploadLargeCSVToS3.uploadCSVToS3("holdings.anksandabhi.dev", prefix, holdingSummaryFileLocation);
    }

    private static String getFormattedCurrentDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MMM_yyyy");
        return formatter.format(localDate);

    }

    private static void testHoldingsToCPOnEmrCluster() throws InterruptedException {
        String costPriceFilesLocation="s3://costprice.anksandabhi.dev/costPrice/"+getFormattedCurrentDate()+"/cp.csv";
        GenerateCostPriceFromHoldingsSummaryEMRClusterJob.generateCostPriceFileFromHoldingsSummary(costPriceFilesLocation);
    }
}
