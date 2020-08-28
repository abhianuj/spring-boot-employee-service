package com.sap.springhanacloudfoundry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
	       exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class SpringHanaCloudFoundryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHanaCloudFoundryApplication.class, args);
	}

}
