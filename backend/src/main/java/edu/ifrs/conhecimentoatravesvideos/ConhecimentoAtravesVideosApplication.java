package edu.ifrs.conhecimentoatravesvideos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ConhecimentoAtravesVideosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConhecimentoAtravesVideosApplication.class, args);
	}

}
