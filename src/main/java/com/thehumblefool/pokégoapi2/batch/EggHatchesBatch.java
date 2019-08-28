/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.batch;

import com.thehumblefool.pokégoapi2.models.entities.EggHatchEntityModel;
import com.thehumblefool.pokégoapi2.services.AmazonS3Service;
import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ByteArrayResource;

/**
 *
 * @author TheHumbleFool
 */
@Configuration
@PropertySource("classpath:amazon_s3_config.properties")
@ConfigurationProperties(prefix = "s3")
public class EggHatchesBatch {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AmazonS3Service s3Service;

    private String batchFilesBucketName;

    public String getBatchFilesBucketName() {
        return batchFilesBucketName;
    }

    public void setBatchFilesBucketName(String batchFilesBucketName) {
        this.batchFilesBucketName = batchFilesBucketName;
    }

    @Bean(name = "eggHatchItemReader")
    @StepScope
    public FlatFileItemReader<EggHatchEntityModel> eggHatchItemReader(@Value(value = "#{jobParameters['fileName']}") String fileName, 
            @Autowired @Qualifier(value = "eggHatchLineMapper") LineMapper<EggHatchEntityModel> lineMapper) throws IOException {
        byte[] csvFile = s3Service.getCsvFile(getBatchFilesBucketName(), fileName);
        for (byte b : csvFile) {
            System.out.print((char) b);
        }
        return new FlatFileItemReaderBuilder<EggHatchEntityModel>()
                .name("egg-hatch-reader")
                .resource(new ByteArrayResource(csvFile))
                .linesToSkip(1)
                .lineMapper(lineMapper)
                .build();
    }

    @Bean(name = "eggHatchLineMapper")
    @StepScope
    public LineMapper<EggHatchEntityModel> eggHatchLineMappper(@Autowired @Qualifier(value = "eggHatchFieldSetMapper") FieldSetMapper<EggHatchEntityModel> fieldSetMapper, 
            @Autowired @Qualifier(value = "eggHatchTokenizer") DelimitedLineTokenizer tokenizer) {
        DefaultLineMapper<EggHatchEntityModel> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean(name = "eggHatchFieldSetMapper")
    @StepScope
    public FieldSetMapper<EggHatchEntityModel> eggHatchFieldSetMapper() {
        return new BeanWrapperFieldSetMapper<>() {
            {
                setTargetType(EggHatchEntityModel.class);
            }
        };
    }

    @Bean(name = "eggHatchTokenizer")
    @StepScope
    public DelimitedLineTokenizer eggHatchTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(",");
        tokenizer.setStrict(false);
        tokenizer.setNames("pokédex", "pokémon", "type_1", "type_2", "hatch_distance", "min_cp", "max_cp", "shiny_available");
        return tokenizer;
    }

    @Bean(name = "eggHatchItemProcessor")
    @StepScope
    public ItemProcessor<EggHatchEntityModel, EggHatchEntityModel> eggHatchItemProcessor() {
        return (t) -> {
            System.out.println("Processing pokémon: " + t.getPokémon());
            return t;
        };
    }

//    @Bean
//    public JpaItemWriter<EggHatchEntityModel> eggHatchItemWriter() throws Exception {
//        JpaItemWriter<EggHatchEntityModel> jpaItemWriter = new JpaItemWriter<>();
//        jpaItemWriter.setEntityManagerFactory(emf);
//        jpaItemWriter.afterPropertiesSet();
//        return jpaItemWriter;
//    }
    @Bean(name = "eggHatchItemWriter")
    @StepScope
    public JdbcBatchItemWriter<EggHatchEntityModel> eggHatchItemWriter() {
        return new JdbcBatchItemWriterBuilder<EggHatchEntityModel>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO egg_hatch_list (poké_dex,pokémon,type_1,type_2,hatch_distance,min_cp,max_cp,shiny_available) VALUES (:pokéDex, :pokémon, :type1, :type2, :hatchDistance, :minCp, :maxCp, :shinyAvailable)")
                .dataSource(dataSource)
                .build();
    }

    @Bean(name = "eggHatchesBatchJob")
    public Job eggHatchesJob(@Autowired @Qualifier(value = "eggHatchJobStep") Step step, 
            @Autowired JobExecutionListener listener) throws Exception {
        return jobBuilderFactory.get("egg-hatches-job")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step)
                .end()
                .build();
    }

    @Bean(name = "eggHatchJobStep")
    public Step eggHatchJobStep(@Autowired @Qualifier(value = "eggHatchItemReader") ItemReader<EggHatchEntityModel> reader, 
            @Autowired @Qualifier(value = "eggHatchItemProcessor") ItemProcessor<EggHatchEntityModel, EggHatchEntityModel> processor, 
            @Autowired @Qualifier(value = "eggHatchItemWriter") ItemWriter<EggHatchEntityModel> writer) throws IOException, Exception {
        return stepBuilderFactory.get("step1")
                .<EggHatchEntityModel, EggHatchEntityModel>chunk(25)
                .reader(reader)
                .processor(eggHatchItemProcessor())
                .writer(writer)
                .build();
    }
}
