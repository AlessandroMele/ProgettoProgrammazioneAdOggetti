package it.progettoOOP.controller;

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
		JSONObject myobj = JSONManager.readURL();
		ArrayListFacebookPost myarray = JSONManager.JSONParser(myobj);
		return new ResponseEntity<>(myarray, HttpStatus.OK);
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)

	public ResponseEntity<Object> getStats(@RequestParam(value = "length") String param,
			@RequestParam(value = "emoji") boolean emoji) throws Exception {

		String[] length = param.split(",");
		String min = length[0];
		String max = length[1];

		int minLength = Integer.parseInt(min);
		int maxLength = Integer.parseInt(max);

		Statistics myst = new Statistics();
		JSONObject myobj = JSONManager.readURL();
		ArrayListFacebookPost myarray = JSONManager.JSONParser(myobj);
		ArrayListFacebookPost filteredposts = new ArrayListFacebookPost();
		filteredposts = Filters.FilteredPostsByParam(myarray, minLength, maxLength, emoji);

		return new ResponseEntity<>(myst.StatisticsReports(filteredposts), HttpStatus.OK);
	}

	@RequestMapping(value = "/filters", method = RequestMethod.GET)

	public ResponseEntity<Object> getFilters(@RequestBody FiltersModel filtro) throws Exception {
		JSONObject myobj = JSONManager.readURL();
		ArrayListFacebookPost myarray = JSONManager.JSONParser(myobj);
		ArrayListFacebookPost filteredposts = new ArrayListFacebookPost();
		filteredposts = Filters.FilteredPosts(myarray, filtro);
		return new ResponseEntity<>(filteredposts, HttpStatus.OK);
	}
}