package com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
	
	@Value("${data.server.url}")
	private String dataServerUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String atmString = restTemplate.getForObject(dataServerUrl, String.class);
			String validJsonString = null;
			
			int validJsonStartsFrom = atmString.indexOf("[");
			if (validJsonStartsFrom > 0) {
				validJsonString = atmString.substring(validJsonStartsFrom, atmString.length());
			} else {
				validJsonString = atmString;
			}
			Path path = Paths.get("src/main/resources/Atm.json");
			try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
			    writer.write(validJsonString);
			} catch(IOException ex){
			    ex.printStackTrace();
			}
		};
	}
}