package dev.anksandabhi;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

import java.io.File;

public class AwsUtils {

    private static final String AWS_INDIA_AZ = "ap-south-1";
    private static final String MY_PERSONAL_CREDENTIALS_PROFILE = "abhinav_personal";

    public static AWSCredentials getAwsCredentialsFromMyLocalMachine() {
        ProfileCredentialsProvider profileCredentialsProvider = new ProfileCredentialsProvider(MY_PERSONAL_CREDENTIALS_PROFILE);
        return profileCredentialsProvider.getCredentials();
    }

    public static AWSCredentials getAwsCredentialsOnCluster() {
        ProfileCredentialsProvider profileCredentialsProvider = new ProfileCredentialsProvider(MY_PERSONAL_CREDENTIALS_PROFILE);
        return profileCredentialsProvider.getCredentials();
    }

    public static AmazonS3 getS3Client() {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(AWS_INDIA_AZ)
                .withCredentials(new ProfileCredentialsProvider(MY_PERSONAL_CREDENTIALS_PROFILE))
                .build();
        return s3Client;
    }

    public static TransferManager getTransferManagerForVeryLargeFileUpload() {
        return TransferManagerBuilder.standard().withS3Client(getS3Client()).build();
    }

    public static String uploadFileMultipartToS3(String absolutePathOfFileToBeUploaded, String bucketName, String prefix) throws InterruptedException {
        try {
            TransferManager transferManager = getTransferManagerForVeryLargeFileUpload();
            Upload upload = transferManager.upload(bucketName, prefix, new File(absolutePathOfFileToBeUploaded));
            System.out.println("Object upload started");

            // Optionally, wait for the upload to finish before continuing.
            upload.waitForCompletion();
            System.out.println("Object upload complete");
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
        return prefix;
    }
}
