package dev.anksandabhi.sparkjob2;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;

public class AwsUtils {

    public static AWSCredentials getAwsCredentials() {
        ProfileCredentialsProvider profileCredentialsProvider = new ProfileCredentialsProvider("abhinav_personal");
        return profileCredentialsProvider.getCredentials();
    }
}
