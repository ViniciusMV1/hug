package br.com.hug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HugApplication {

	public static void main(String[] args) {
		SpringApplication.run(HugApplication.class, args);
	}

}
