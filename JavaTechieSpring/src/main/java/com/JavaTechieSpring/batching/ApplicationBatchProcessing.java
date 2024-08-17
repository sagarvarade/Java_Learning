package com.JavaTechieSpring.batching;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class ApplicationBatchProcessing {

    @Autowired
    private CSVRepository repository;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public FlatFileItemReader<CSVBean> itemReader() {
        FlatFileItemReader<CSVBean> flatFileItemReader = new FlatFileItemReader<>();
        itemReader().setResource(new FileSystemResource("E://MOCK_DATA.csv"));
        itemReader().setLinesToSkip(1);
        itemReader().setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    private LineMapper<CSVBean> lineMapper() {
        DefaultLineMapper<CSVBean> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender");

        BeanWrapperFieldSetMapper<CSVBean> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(CSVBean.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    public CSVProcessor processor(){
        return  new CSVProcessor();
    }

    @Bean
    public RepositoryItemWriter<CSVBean> itemWriter(){
        RepositoryItemWriter<CSVBean> itemWriter=new RepositoryItemWriter<>();
        itemWriter.setRepository(repository);
        itemWriter.setMethodName("save");
        return  itemWriter;
    }

    public Step ImportCSVStep(){
        return stepBuilderFactory.get("ImportCSVStep").<CSVBean,CSVBean> chunk(10)
                .reader(itemReader())
                .processor(processor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Job runJob(){
        return  jobBuilderFactory.get("importcsvdata")
                .flow(ImportCSVStep())
                .end().build();
    }
}
