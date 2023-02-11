package com.abhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbhinandanMartApplication {
      public String PORT=System.getenv("PORT");
	public static void main(String[] args) {
		
		SpringApplication.run(AbhinandanMartApplication.class, args);
	}

}
