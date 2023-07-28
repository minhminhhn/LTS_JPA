package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication extends Exception{

	public static void main(String[] args) {
		try {
			SpringApplication.run(StudentApplication.class, args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
