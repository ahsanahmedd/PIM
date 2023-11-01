package com.wsgc.PIMbackend;

import com.wsgc.PIMbackend.model.Category;
import com.wsgc.PIMbackend.model.SuperCategory;
import com.wsgc.PIMbackend.repositary.CategoryRepositary;
import com.wsgc.PIMbackend.repositary.SuperCategoryRepositary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PimBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PimBackendApplication.class, args);
	}
	@Autowired
	private SuperCategoryRepositary superCategoryRepositary;
	@Autowired
	private CategoryRepositary categoryRepositary;


	@Override
	public void run(String... args) throws Exception {
		SuperCategory superCategory = new SuperCategory();



		superCategory.setName("Electronics");
		superCategory.setSeoCopy("new new");


		superCategoryRepositary.save(superCategory);

	}
}
