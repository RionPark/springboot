package com.ezen.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		try {
			Integer.parseInt("백십");
		}catch(NumberFormatException nfe) {
			System.out.println("야 숫자 써야지!!");
		}
		System.out.println("나 실행 안되남?");
	}
}
