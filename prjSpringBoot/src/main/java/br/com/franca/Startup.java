package br.com.franca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import br.com.franca.config.FileStorageConfig;

// quando a aplicação iniciar leia as informnações do app.prperties e armazene nessa classe FileStorageConfig 
@EnableConfigurationProperties({ FileStorageConfig.class })
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Startup {
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
		/*
		 * BCryptPasswordEncoder bCryptPasswordEncoder = new
		 * BCryptPasswordEncoder(16); String result =
		 * bCryptPasswordEncoder.encode("admin123"); System.out.println(
		 * "My hash " + result);
		 */
	}
}
