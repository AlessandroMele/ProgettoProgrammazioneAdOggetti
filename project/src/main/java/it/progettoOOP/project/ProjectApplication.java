package it.progettoOOP.project;

import it.progettoOOP.controller.Controller;
import it.progettoOOP.model.FacebookPost;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = Controller.class)
public class ProjectApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProjectApplication.class, args);
		
		/*
		try {            
	         FacebookPost c = new FacebookPost();
	         Class cls = c.getClass();
	         Field[] fields = cls.getDeclaredFields();
	         String nomi4 = String.getName();
	         for(int i = 0; i < fields.length; i++) {
	            System.out.println(fields[i] + "         " + nomi4 + "    " + fields[i].toString());
	         }
	      } catch(Exception e) {
	         System.out.println(e.toString());
	      }
		*/
	}	
}
