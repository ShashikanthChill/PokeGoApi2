/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.batch;

import com.thehumblefool.pokégoapi2.models.entities.ResearchBreakthroughEncounterEntityModel;
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
public class EncountersBatch {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    DataSource dataSource;

    @Autowired
    AmazonS3Service s3Service;

    private String batchFilesBucketName;

    public String getBatchFilesBucketName() {
        return batchFilesBucketName;
    }

    public void setBatchFilesBucketName(String batchFilesBucketName) {
        this.batchFilesBucketName = batchFilesBucketName;
    }

    @Bean(name = "encounterItemReader")
    @StepScope
    public FlatFileItemReader<ResearchBreakthroughEncounterEntityModel> encounterItemReader(@Value(value = "#{jobParameters['fileName']}") String fileName,
            @Autowired @Qualifier(value = "encounterLineMapper") LineMapper<ResearchBreakthroughEncounterEntityModel> lineMapper) throws IOException {
        byte[] csvFile = s3Service.getCsvFile(getBatchFilesBucketName(), fileName);
        for (byte b : csvFile) {
            System.out.print((char) b);
        }
        return new FlatFileItemReaderBuilder<ResearchBreakthroughEncounterEntityModel>()
                .name("encounter-reader")
                .resource(new ByteArrayResource(csvFile))
                .linesToSkip(1)
                .lineMapper(lineMapper)
                .build();
    }

    @Bean(name = "encounterLineMappper")
    @StepScope
    public LineMapper<ResearchBreakthroughEncounterEntityModel> encounterLineMappper(@Autowired @Qualifier(value = "encounterFieldSetMapper") FieldSetMapper<ResearchBreakthroughEncounterEntityModel> fieldSetMapper,
            @Autowired @Qualifier(value = "encouterTokenizer") DelimitedLineTokenizer tokenizer) {
        DefaultLineMapper<ResearchBreakthroughEncounterEntityModel> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean(name = "encounterFieldSetMapper")
    @StepScope
    public FieldSetMapper<ResearchBreakthroughEncounterEntityModel> encounterFieldSetMapper() {
        return new BeanWrapperFieldSetMapper<>() {
            {
                setTargetType(ResearchBreakthroughEncounterEntityModel.class);
            }
        };
    }

    @Bean
    public DelimitedLineTokenizer encounterTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(",");
        tokenizer.setStrict(false);
        tokenizer.setNames("pokédex", "pokémon", "type_1", "type_2", "min_cp", "max_cp", "shiny_available");
        return tokenizer;
    }

    @Bean(name = "encounterItemProcessor")
    @StepScope
    public ItemProcessor<ResearchBreakthroughEncounterEntityModel, ResearchBreakthroughEncounterEntityModel> encounterItemProcessor() {
        return (t) -> {
            System.out.println("Processing pokémon: " + t.getPokémon());
            return t;
        };
    }

//    @Bean
//    public JpaItemWriter<ResearchBreakthroughEncounterEntityModel> encountersItemWriter() throws Exception {
//        JpaItemWriter<ResearchBreakthroughEncounterEntityModel> jpaItemWriter = new JpaItemWriter<>();
//        jpaItemWriter.setEntityManagerFactory(emf);
//        jpaItemWriter.afterPropertiesSet();
//        return jpaItemWriter;
//    }
    @Bean(name = "encounterItemWriter")
    @StepScope
    public JdbcBatchItemWriter<ResearchBreakthroughEncounterEntityModel> encounterItemWriter() {
        return new JdbcBatchItemWriterBuilder<ResearchBreakthroughEncounterEntityModel>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO encounters_batch (pokédex,pokémon,type_1,type_2,min_cp,max_cp,shiny_available) VALUES (:pokéDex, :pokémon, :type1, :type2, :minCp, :maxCp, :shinyAvailable)")
                .dataSource(dataSource)
                .build();
    }

    @Bean(name = "encountersBatchJob")
    public Job encountersJob(@Autowired @Qualifier(value = "encounterJobStep") Step step,
            @Autowired JobExecutionListener listener) throws Exception {
        return jobBuilderFactory.get("encounters-job")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step)
                .end()
                .build();
    }

    @Bean(name = "encounterJobStep")
    public Step encounterJobStep(@Autowired @Qualifier(value = "encounterItemReader") ItemReader<ResearchBreakthroughEncounterEntityModel> reader,
            @Autowired @Qualifier(value = "encounterItemProcessor") ItemProcessor<ResearchBreakthroughEncounterEntityModel, ResearchBreakthroughEncounterEntityModel> processor,
            @Autowired @Qualifier(value = "encounterItemWriter") ItemWriter<ResearchBreakthroughEncounterEntityModel> writer) throws IOException, Exception {
        return stepBuilderFactory.get("step1")
                .<ResearchBreakthroughEncounterEntityModel, ResearchBreakthroughEncounterEntityModel>chunk(25)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
