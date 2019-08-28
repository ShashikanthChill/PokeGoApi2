/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.batch;

import com.thehumblefool.pokégoapi2.models.entities.RaidEntityModel;
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
public class RaidsBatch {

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
        System.out.println("batch files setter called");
        this.batchFilesBucketName = batchFilesBucketName;
    }

    @Bean(name = "raidItemReader")
    @StepScope
    public FlatFileItemReader<RaidEntityModel> raidItemReader(@Value(value = "#{jobParameters['fileName']}") String fileName,
            @Autowired @Qualifier(value = "raidLineMapper") LineMapper<RaidEntityModel> lineMapper) throws IOException {
        byte[] csvFile = s3Service.getCsvFile(getBatchFilesBucketName(), fileName);
        for (byte b : csvFile) {
            System.out.print((char) b);
        }
        return new FlatFileItemReaderBuilder<RaidEntityModel>()
                .name("raid-reader")
                .resource(new ByteArrayResource(csvFile))
                .linesToSkip(1)
                .lineMapper(lineMapper)
                .build();
    }

    @Bean(name = "raidLineMapper")
    @StepScope
    public LineMapper<RaidEntityModel> raidLineMappper(@Autowired @Qualifier(value = "raidFieldSetMapper") FieldSetMapper<RaidEntityModel> fieldSetMapper,
            @Autowired @Qualifier(value = "raidTokenizer") DelimitedLineTokenizer tokenizer) {
        DefaultLineMapper<RaidEntityModel> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(raidTokenizer());
        lineMapper.setFieldSetMapper(raidFieldSetMapper());
        return lineMapper;
    }

    @Bean(name = "raidFieldSetMapper")
    @StepScope
    public FieldSetMapper<RaidEntityModel> raidFieldSetMapper() {
        return new BeanWrapperFieldSetMapper<>() {
            {
                setTargetType(RaidEntityModel.class);
            }
        };
    }

    @Bean(name = "raidTokenizer")
    @StepScope
    public DelimitedLineTokenizer raidTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(",");
        tokenizer.setStrict(false);
        tokenizer.setNames("poké_dex", "pokémon", "type_1", "type_2", "tier", "gen", "raid_cp", "min_cp_non_boosted", "max_cp_non_boosted", "min_cp_boosted", "max_cp_boosted", "group_size_difficulty", "shiny_available");
        return tokenizer;
    }

    @Bean(name = "raidItemProcessor")
    @StepScope
    public ItemProcessor<RaidEntityModel, RaidEntityModel> raidItemProcessor() {
        return (t) -> {
            System.out.println("Processing pokémon: " + t.getPokémon());
            return t;
        };
    }

//    @Bean
//    public JpaItemWriter<RaidEntityModel> raidItemWriter() throws Exception {
//        JpaItemWriter<RaidEntityModel> jpaItemWriter = new JpaItemWriter<>();
//        jpaItemWriter.setEntityManagerFactory(emf);
//        jpaItemWriter.afterPropertiesSet();
//        return jpaItemWriter;
//    }
    @Bean(name = "raidItemWriter")
    @StepScope
    public JdbcBatchItemWriter<RaidEntityModel> raidItemWriter() {
        return new JdbcBatchItemWriterBuilder<RaidEntityModel>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO raids_list (poké_dex,pokémon,type_1,type_2,tier,gen,raid_cp,min_cp_non_boosted,max_cp_non_boosted,min_cp_boosted,max_cp_boosted,group_size_difficulty,shiny_available) VALUES (:pokéDex, :pokémon, :type1, :type2, :tier, :gen, :raidCp, :minCpNonBoosted, :maxCpNonBoosted, :minCpBoosted, :maxCpBoosted, :groupSizeDifficulty, :shinyAvailable)")
                .dataSource(dataSource)
                .build();
    }

    @Bean(name = "raidsBatchJob")
    public Job raidsJob(@Autowired @Qualifier(value = "raidJobStep") Step step,
            @Autowired JobExecutionListener listener) throws Exception {
        return jobBuilderFactory.get("raids-job")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step)
                .end()
                .build();
    }

    @Bean(name = "raidJobStep")
    public Step raidJobStep(@Autowired @Qualifier(value = "raidItemReader") ItemReader<RaidEntityModel> reader,
            @Autowired @Qualifier(value = "raidItemProcessor") ItemProcessor<RaidEntityModel, RaidEntityModel> processor,
            @Autowired @Qualifier(value = "raidItemWriter") ItemWriter<RaidEntityModel> writer) throws IOException, Exception {
        return stepBuilderFactory.get("step1")
                .<RaidEntityModel, RaidEntityModel>chunk(25)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
