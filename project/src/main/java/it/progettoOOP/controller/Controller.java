/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.controller;

import java.util.ArrayList;
import org.json.JSONException;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import it.progettoOOP.exceptions.*;
import it.progettoOOP.filters.*;
import it.progettoOOP.manageJSON.*;
import it.progettoOOP.model.*;
import it.progettoOOP.stats.*;

@RestController
public class Controller {

	@RequestMapping(value = "/data", method = RequestMethod.GET)

	public ResponseEntity<Object> getPosts() throws JSONException {
		ArrayList<FacebookPost> array = JSONManager.JSONParser(JSONManager.readURL());
		return new ResponseEntity<>(array, HttpStatus.OK);
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)

	public ResponseEntity<Object> getStats(@RequestParam(value = "minLength") int minLength,
			@RequestParam(value = "maxLength") int maxLength, @RequestParam(value = "emoji") String emoji)
			throws MissingServletRequestParameterException, JsonProcessingException, BadRangeValueException,
			BadValueException, BadStringException {

		ArrayList<FacebookPost> array = JSONManager.JSONParser(JSONManager.readURL());
		ArrayList<FacebookPost> filteredArray = Filtering.FilteredPostsByParam(array, minLength, maxLength, emoji);
		Statistics mystats = new Statistics(filteredArray, array);
		return new ResponseEntity<>(mystats, HttpStatus.OK);
	}

	@RequestMapping(value = "/filters", method = { RequestMethod.POST, RequestMethod.PUT })

	public ResponseEntity<Object> getFilters(@RequestBody Filters filter) throws Exception {
		ArrayList<FacebookPost> array = JSONManager.JSONParser(JSONManager.readURL());
		ArrayList<FacebookPost> filteredArray = Filtering.FilteredPosts(array, filter);
		return new ResponseEntity<>(filteredArray, HttpStatus.OK);
	}

}