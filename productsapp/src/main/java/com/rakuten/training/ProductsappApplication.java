package com.rakuten.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductsappApplication {
	
	public static void main(String[] args) {
		ApplicationContext springContainer =
				SpringApplication.run(ProductsappApplication.class, args);
		
		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
		ui.createProductWithUI();
	}

}
