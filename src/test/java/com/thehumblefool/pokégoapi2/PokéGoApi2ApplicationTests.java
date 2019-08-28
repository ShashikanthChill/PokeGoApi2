package com.thehumblefool.pokégoapi2;

import com.amazonaws.services.s3.AmazonS3;
import com.thehumblefool.pokégoapi2.services.AmazonS3Service;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource(value = "classpath:amazon_s3_config.properties")
public class PokéGoApi2ApplicationTests {

    @Autowired
    AmazonS3 s3;

    @Autowired
    AmazonS3Service s3Service;

    @Value(value = "${s3.batch_files_bucket_name}")
    String bucketName;

    @Test
    public void checkS3Client() {
        Assert.assertNotNull("S3 is null", s3);
    }

    @Test
    public void checkBucketName() {
        Assert.assertNotNull("Bucket Name is not loaded from properties file.", bucketName);
    }

    @Test
    public void checkObject() {
        Assert.assertNotNull("Object from S3 not loaded.", s3.getObject(bucketName, "egg-pool-list.csv"));
    }

    @Test
    public void checkObjectStream() throws IOException {
        Assert.assertNotNull("Object stream from S3 not loaded.", s3Service.getCsvFile(bucketName, "egg-pool-list.csv"));
    }
    
    @Test
    public void checkObjectStreamData() throws IOException {
        System.out.println(s3Service.getCsvFile(bucketName, "egg-pool-list.csv").length);
    }

}
