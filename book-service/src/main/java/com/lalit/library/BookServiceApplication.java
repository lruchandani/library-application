package com.lalit.library;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication {

  private static final Logger LOG = getLogger(BookServiceApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Value("${spring.datasource.url}")
	String datasourceurl;

	@Bean
	CommandLineRunner commandLineRunner(){
    return (arg) -> {
      LOG.info("Datasource url :" + datasourceurl);
      System.out.println("Datasource url :" + datasourceurl);
    };
	}



}

