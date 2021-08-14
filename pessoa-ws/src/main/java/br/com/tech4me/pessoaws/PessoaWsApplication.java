package br.com.tech4me.pessoaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PessoaWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaWsApplication.class, args);
	}

}
