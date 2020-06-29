package it.progettoOOP.project;

import it.progettoOOP.manageJSON.DownloadJSON;

import it.progettoOOP.manageJSON.ParseJSON;
import it.progettoOOP.model.ArrayListFacebookPost;
import it.progettoOOP.model.FacebookPost;
import it.progettoOOP.stats.Statistics;

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
		System.out.println(Statistics.StatisticValues(myarray));
		
		
	}
}
