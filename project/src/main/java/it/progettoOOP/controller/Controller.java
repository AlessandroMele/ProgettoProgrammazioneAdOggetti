/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.controller;

import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import it.progettoOOP.exceptions.BadRangeValueException;
import it.progettoOOP.exceptions.BadStringException;
import it.progettoOOP.exceptions.BadValueException;
import it.progettoOOP.filters.*;
import it.progettoOOP.manageJSON.*;
import it.progettoOOP.model.*;
import it.progettoOOP.stats.*;

@RestController
public class Controller {

	@RequestMapping(value = "/metadata", method = RequestMethod.GET)

	public ResponseEntity<Object> getPosts() throws JSONException {
		ArrayList<FacebookPost> array = JSONManager.JSONParser(JSONManager.readURL());
		return new ResponseEntity<>(array, HttpStatus.OK);
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)

	public ResponseEntity<Object> getStats(@RequestParam(value = "rangeLength", defaultValue = "0,10000") String param,
			@RequestParam(value = "emoji", defaultValue = "notSpecified") String emoji)
			throws MissingServletRequestParameterException, NumberFormatException, JsonProcessingException,
			BadRangeValueException, BadValueException, BadStringException {

		ArrayList<FacebookPost> array = JSONManager.JSONParser(JSONManager.readURL());
		ArrayList<FacebookPost> filteredArray = Filtering.FilteredPostsByParam(array, param, emoji);
		Statistics mystats = new Statistics(filteredArray, array);
		String JSONStats = "";
		try {
			JSONStats = JSONManager.JSONGenerator(mystats);
		} catch (JsonProcessingException e) {
			JSONStats = "No stats";
		}
		return new ResponseEntity<>(mystats, HttpStatus.OK);
	}

	@RequestMapping(value = "/filters", method = { RequestMethod.POST, RequestMethod.PUT })

	public ResponseEntity<Object> getFilters(@RequestBody Filters filter) throws Exception {
		ArrayList<FacebookPost> array = JSONManager.JSONParser(JSONManager.readURL());

		ArrayList<FacebookPost> filteredArray = Filtering.FilteredPosts(array, filter);
		return new ResponseEntity<>(filteredArray, HttpStatus.OK);
	}

}