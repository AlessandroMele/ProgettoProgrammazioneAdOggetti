package it.progettoOOP.controller;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.progettoOOP.filters.Filters;
import it.progettoOOP.filters.FiltersModel;
import it.progettoOOP.manageJSON.JSONManager;
import it.progettoOOP.model.ArrayListFacebookPost;
import it.progettoOOP.stats.*;

@RestController
public class SimpleController {

	@RequestMapping(value = "/data", method = RequestMethod.GET)

	public ResponseEntity<Object> getPost() throws JSONException {
		JSONManager myp = new JSONManager();
		JSONObject myobj = myp.readURL();
		ArrayListFacebookPost myarray = myp.JSONParser(myobj);
		return new ResponseEntity<>(myarray, HttpStatus.OK);
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)

	public ResponseEntity<Object> getStats(@RequestParam(value = "length") String param, @RequestParam(value="emoji") String emoji) throws Exception {
		String[] length = param.split(",");
		String min = length[0];
		String max = length[1];
		boolean emoticon = false;
		if (emoji.contentEquals("true")) emoticon = true;
				else emoticon = false;
		int minLength = Integer.parseInt(min);
		int maxLength = Integer.parseInt(max);
		Statistics myst = new Statistics();
		JSONManager myp = new JSONManager();
		JSONObject myobj = myp.readURL();
		Filters fil = new Filters();
		ArrayListFacebookPost myarray = myp.JSONParser(myobj);
		ArrayListFacebookPost filposts = new ArrayListFacebookPost();
		filposts = fil.FilteredPostsByParam(myarray,minLength,maxLength,emoticon);	
		return new ResponseEntity<>(myst.StatisticsReports(filposts) , HttpStatus.OK);
	}

	
	@RequestMapping(value = "/filters", method = RequestMethod.GET)

	public ResponseEntity<Object> getFilters(@RequestBody FiltersModel filtro) throws Exception {
		JSONManager myp = new JSONManager();
		JSONObject myobj = myp.readURL();
		Filters fil = new Filters();
		ArrayListFacebookPost myarray = myp.JSONParser(myobj);
		ArrayListFacebookPost filposts = new ArrayListFacebookPost();
		filposts = fil.FilteredPosts(myarray,filtro);	
		return new ResponseEntity<>( filposts, HttpStatus.OK);
	}
}