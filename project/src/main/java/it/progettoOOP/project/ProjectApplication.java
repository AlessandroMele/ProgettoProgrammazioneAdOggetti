package it.progettoOOP.project;

import it.progettoOOP.manageJSON.DownloadJSON;
import it.progettoOOP.manageJSON.ParseJSON;
import it.progettoOOP.model.FacebookPost;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProjectApplication.class, args);
		JSONObject myobj = DownloadJSON.readURL();
		ArrayList<FacebookPost> myarray = ParseJSON.JSONParser(myobj);
		myarray.toString();
	}
}
