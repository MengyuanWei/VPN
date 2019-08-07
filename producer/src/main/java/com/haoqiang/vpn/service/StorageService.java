package com.haoqiang.vpn.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author Haoqiang Lyu
 * @date 2019-07-22 21:55
 */

//@Service
public class StorageService {

    private AmazonS3 s3;
    private String bucket;

    public StorageService(AmazonS3 s3) {
        this.s3 = s3;
    }


    public void putObject(String S3Key, File file) {
        s3.putObject(bucket, S3Key, file);
    }


    public S3Object getObject(String S3key) {
        return s3.getObject(bucket, S3key);
    }

    public String getObjectUrl(String S3key) {
        return s3.getUrl(bucket, S3key).toString();

    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }



}
