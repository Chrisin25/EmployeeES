package com.example.EmployeeDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EmployeeDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDbApplication.class, args);
	}

}
