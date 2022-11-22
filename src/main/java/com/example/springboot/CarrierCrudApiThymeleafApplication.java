package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class CarrierCrudApiThymeleafApplication {

	public static void main(String[] args) {
		CarrierCrudApiThymeleafApplication carrierCrudApiThymeleafApplication = new CarrierCrudApiThymeleafApplication();
		SpringApplication.run(CarrierCrudApiThymeleafApplication.class, args);
	}

}
