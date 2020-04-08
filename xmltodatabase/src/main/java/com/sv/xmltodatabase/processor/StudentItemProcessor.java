package com.sv.xmltodatabase.processor;

import org.springframework.batch.item.ItemProcessor;

import com.sv.xmltodatabase.model.Student;

public class StudentItemProcessor implements ItemProcessor<Student,Student>{

	@Override
	public Student process(Student student) throws Exception {
		return student;
	}

}
