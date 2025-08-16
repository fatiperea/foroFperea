package com.perea.ForoFPerea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ForoFPereaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForoFPereaApplication.class, args);
	}

}
