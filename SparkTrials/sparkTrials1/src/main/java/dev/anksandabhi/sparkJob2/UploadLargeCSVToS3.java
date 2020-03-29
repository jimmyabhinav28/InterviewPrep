package dev.anksandabhi.sparkJob2;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import dev.anksandabhi.AwsUtils;

import java.io.File;

public class UploadLargeCSVToS3 {

    public static String uploadCSVToS3(String bucket,String prefix,String absolutePathToLargeCSV) throws InterruptedException {
        return AwsUtils.uploadFileMultipartToS3(absolutePathToLargeCSV,bucket,prefix);
    }
}
