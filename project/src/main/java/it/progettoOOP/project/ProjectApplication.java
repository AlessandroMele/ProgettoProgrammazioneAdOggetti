package it.progettoOOP.project;

import it.progettoOOP.filters.Filters;
import it.progettoOOP.manageJSON.DownloadJSON;
import it.progettoOOP.manageJSON.ParseJSON;
import it.progettoOOP.model.ArrayListFacebookPost;
import it.progettoOOP.stats.Statistics;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProjectApplication.class, args);
		DownloadJSON myd = new DownloadJSON();
		ParseJSON myp = new ParseJSON();
		JSONObject myobj = myd.readURL();
		Statistics mystat = new Statistics();
		Filters myf = new Filters();
		ArrayListFacebookPost myarray = myp.JSONParser(myobj);
		System.out.println(myarray);
		System.out.println(mystat.StatisticsReports(myarray));
		ArrayListFacebookPost provaFiltroLunghezzaTesto = myf.filterByLengthMessage(myarray, 1204);
		System.out.println(provaFiltroLunghezzaTesto);
		ArrayListFacebookPost provaFiltroParametro = myf.filterByShares(myarray, 8);
		System.out.println(provaFiltroParametro);

	}
}
