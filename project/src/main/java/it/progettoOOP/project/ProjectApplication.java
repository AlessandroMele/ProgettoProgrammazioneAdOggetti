package it.progettoOOP.project;

import it.progettoOOP.manageJSON.DownloadJSON;

import it.progettoOOP.manageJSON.ParseJSON;
import it.progettoOOP.model.ArrayListFacebookPost;
import it.progettoOOP.model.FacebookPost;
import it.progettoOOP.stats.statistics;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.progettoOOP.stats.*; 


@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProjectApplication.class, args);
		JSONObject myobj = DownloadJSON.readURL();
		ArrayListFacebookPost myarray = ParseJSON.JSONParser(myobj);
		System.out.println(myarray);
		System.out.println("media likes:   " + statistics.media(myarray));
		System.out.println("massimo numero di likes:   " + statistics.max(myarray));
		System.out.println("minimo numero di likes:   " + statistics.min(myarray));
		System.out.println("massimo numero di caratteri di un post:   " + statistics.maxLeng(myarray));
		
	}
}
