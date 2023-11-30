package com.wsgc.PIMbackend;

import com.wsgc.PIMbackend.model.Category;
import com.wsgc.PIMbackend.model.SuperCategory;
import com.wsgc.PIMbackend.repositary.CategoryRepositary;
import com.wsgc.PIMbackend.repositary.SuperCategoryRepositary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

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
		superCategory.setCategoryname("Electronics");
		superCategory.setName("Electronics");
		superCategory.setSeoCopy("new new");

		superCategoryRepositary.save(superCategory);

	}
}
