package com.sv.xmltodatabase.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.sv.xmltodatabase.model.Student;
import com.sv.xmltodatabase.processor.StudentItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public StudentItemProcessor processor() {
		return new StudentItemProcessor();
	}
	
	@Bean
	public StaxEventItemReader<Student> reader(){
		StaxEventItemReader<Student> reader = new StaxEventItemReader<Student>();
		reader.setResource(new ClassPathResource("students.xml"));
		reader.setFragmentRootElementName("student");
		
		Map<String,String> aliasesMap =new HashMap<String,String>();
		aliasesMap.put("student", "com.sv.xmltodatabase.model.Student");
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setAliases(aliasesMap);
		
		reader.setUnmarshaller(marshaller);
		return reader;
	}
	
	@Bean
	public JdbcBatchItemWriter<Student> writer(){
		JdbcBatchItemWriter<Student> writer = new JdbcBatchItemWriter<Student>();
		writer.setDataSource(dataSource);
		writer.setSql("INSERT INTO student(student_id,first_name,last_name,email,age) VALUES(?,?,?,?,?)");
		writer.setItemPreparedStatementSetter(new Studentpreparedstatement());
		return writer;
	}
	
	@Bean
	public Step step1(){
		return stepBuilderFactory.get("step1").<Student,Student>chunk(100).reader(reader()).processor(processor()).writer(writer()).build();
	}

	@Bean
	public Job exportPerosnJob(){
		return jobBuilderFactory.get("importPersonJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}
}
