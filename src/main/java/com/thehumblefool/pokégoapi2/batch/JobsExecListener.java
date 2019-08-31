/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.batch;

import com.thehumblefool.pokégoapi2.services.AmazonS3Service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author TheHumbleFool
 */
@Component
@PropertySource("classpath:amazon_s3_config.properties")
@ConfigurationProperties(prefix = "s3")
public class JobsExecListener implements JobExecutionListener {

    private PrintStream ps;

    private File logFile;
    
    private String logFilesBucketName;

    private final AmazonS3Service s3Service;

    @Autowired
    public JobsExecListener(AmazonS3Service s3Service) {
        this.s3Service = s3Service;
    }

    public String getLogFilesBucketName() {
        return logFilesBucketName;
    }

    public void setLogFilesBucketName(String logFilesBucketName) {
        this.logFilesBucketName = logFilesBucketName;
    }
    
    

    @Override
    public void beforeJob(JobExecution jobExecution) {
        String fileName = jobExecution.getJobInstance().getJobName() + "-" + jobExecution.getCreateTime().toString() + "-log file";
        try {
            logFile = File.createTempFile(fileName, ".txt");
            ps = new PrintStream(logFile);
            ps.println("Logging started at: " + new Date().toString() + "\n");
            ps.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            ps.println("Before Job:");
            ps.println("============");
            ps.println("\t-->Job id: " + jobExecution.getJobId());
            ps.println("\t-->Job name: " + jobExecution.getJobInstance().getJobName());
            ps.println("\t-->With parameters: " + jobExecution.getJobParameters().toString());
            ps.println("\t-->Status: " + jobExecution.getStatus().toString());
            ps.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            ps.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JobsExecListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JobsExecListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        ps.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ps.println("After Job:");
        ps.println("===========");
        ps.println("\t-->Status: " + jobExecution.getStatus().toString());
        ps.println("\t-->Creation time: " + jobExecution.getCreateTime());
        ps.println("\t-->End time: " + jobExecution.getCreateTime());
        ps.println("\t-->Exit Status code: " + jobExecution.getExitStatus().getExitCode());
        ps.println("\t-->All Failure Exceptions: ");
        List<Throwable> allFailureExceptions = jobExecution.getAllFailureExceptions();
        if (!allFailureExceptions.isEmpty()) {
            allFailureExceptions.forEach((allFailureException) -> {
                ps.println("\t\t-->Exception: " + allFailureException.toString() + "||" + allFailureException.getMessage());
            });
        } else {
            ps.println("\t\t-->None");
        }
        ps.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        ps.println("End");
        ps.flush();
        ps.close();
        try {
            s3Service.WriteLogs(getLogFilesBucketName(), logFile.getName(), logFile);
        } catch (IOException ex) {
            Logger.getLogger(JobsExecListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
