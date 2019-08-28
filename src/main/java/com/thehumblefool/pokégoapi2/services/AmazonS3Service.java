/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.services;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TheHumbleFool
 */
@Service
public class AmazonS3Service {

    private final AmazonS3 s3;

    @Autowired
    public AmazonS3Service(AmazonS3 s3) {
        System.out.println("s3 service inited");
        this.s3 = s3;
    }

    public byte[] getCsvFile(String bucketName, String fileName) throws IOException {
        try (S3Object s3Object = s3.getObject(bucketName, fileName)) {
            byte[] allBytes = s3Object.getObjectContent().readAllBytes();
            return allBytes;
        } catch (IOException ioe) {
            throw ioe;
        }
    }

    public void WriteLogs(String bucketName, String fileName, File file) throws IOException {
        try {
            s3.putObject(bucketName, fileName, file);
        } catch (SdkClientException e) {
            System.out.println(e.toString());
        }
    }

}
