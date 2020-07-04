package it.progettoOOP.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

	public ResponseEntity<Object> getStats(@RequestParam(value = "rangeLength", defaultValue = "0,10000") String param,
			@RequestParam(value = "emoji", defaultValue ="notSpecified") String emoji) throws MissingServletRequestParameterException {
		int minLength = 0;
		int maxLength = 10000;

		try {
			String[] rangeLength = param.split(",");
			try {
				String min = rangeLength[0];
				minLength = Integer.parseInt(min);
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			try {
				String max = rangeLength[1];
				maxLength = Integer.parseInt(max);
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		} catch (NumberFormatException e) {
		}

		Statistics myst = new Statistics();
		JSONObject myobj = JSONManager.readURL();
		ArrayListFacebookPost myarray = JSONManager.JSONParser(myobj);
		ArrayListFacebookPost filteredposts = new ArrayListFacebookPost();
		filteredposts = Filters.FilteredPostsByParam(myarray, minLength, maxLength, emoji);

		return new ResponseEntity<>(myst, HttpStatus.OK);
	}
	//myst.StatisticsReports(filteredposts,myarray)

	@RequestMapping(value = "/filters", method = RequestMethod.GET)

	public ResponseEntity<Object> getFilters(@RequestBody FiltersModel filtro) throws Exception {
		JSONObject myobj = JSONManager.readURL();
		ArrayListFacebookPost myarray = JSONManager.JSONParser(myobj);
		ArrayListFacebookPost filteredposts = new ArrayListFacebookPost();
		//try {
		filteredposts = Filters.FilteredPosts(myarray, filtro);
		//}
		//catch(HttpMessageNotReadableException e) {			
		//}
		return new ResponseEntity<>(filteredposts, HttpStatus.OK);
	}
}