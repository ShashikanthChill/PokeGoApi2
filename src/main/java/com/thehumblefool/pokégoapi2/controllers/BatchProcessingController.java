/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.controllers;

import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TheHumbleFool
 */
@RestController
public class BatchProcessingController {

    private final Job eggHatchesJob;

    private final Job raidsJob;

    private final Job encountersJob;

    private final JobRepository jobRepository;

    public BatchProcessingController(
            @Autowired @Qualifier(value = "eggHatchesBatchJob") Job eggHatchesJob,
            @Autowired @Qualifier(value = "raidsBatchJob") Job raidsJob,
            @Autowired @Qualifier(value = "encountersBatchJob") Job encountersJob,
            @Autowired JobRepository jobRepository) {
        this.eggHatchesJob = eggHatchesJob;
        this.raidsJob = raidsJob;
        this.encountersJob = encountersJob;
        this.jobRepository = jobRepository;
    }

    @RequestMapping(path = "jobs/{type}")
    public String eggHatchesBatchJobHandler(@PathVariable(value = "type") String type, @RequestParam(value = "file") String fileName) throws JobExecutionAlreadyRunningException, JobRestartException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, Exception {

        JobParameters jobParameters = new JobParametersBuilder().addString("fileName", fileName).addDate("initTime", new Date(System.currentTimeMillis())).toJobParameters();

        SimpleJobLauncher jl = new SimpleJobLauncher();
        jl.setJobRepository(jobRepository);
        jl.setTaskExecutor(new SimpleAsyncTaskExecutor());
        jl.afterPropertiesSet();

        switch (type) {
            case "eggs": {
                jl.run(eggHatchesJob, jobParameters);
                return "Started Job";
            }

            case "raids": {
                jl.run(raidsJob, jobParameters);
                return "Started Job";
            }

            case "encounters": {
                jl.run(encountersJob, jobParameters);
                return "Started Job";
            }
            default:
                throw new Exception("Invalid job called");
        }
    }
}
