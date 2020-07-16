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

/**
 * It allows user to do calls
 */
@RestController
public class Controller {

	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	/**
	 * It allows user to do "/metadata" call
	 * 
	 * @return metadata of FacebookPost
	 */
	public ResponseEntity<Object> getMetaData() throws JSONException {
		return new ResponseEntity<>(MetaData.getMetaData(), HttpStatus.OK);
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	/**
	 * It allows user to do "/data" call
	 * 
	 * @return post contained in the get request
	 */
	public ResponseEntity<Object> getPosts() throws JSONException {
		ArrayList<FacebookPost> array = JSONManager.JSONParser(JSONManager.readURL());
		return new ResponseEntity<>(array, HttpStatus.OK);
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	/**
	 * It allows user to do "/stats" call
	 * 
	 * @param minLength the value of minimum length message
	 * @param maxLength the value of maximum length message
	 * @param emoji     the string for selecting or not emoji presence on a message
	 * @return list of posts that satisfies statistics parameters
	 */
	public ResponseEntity<Object> getStats(@RequestParam(value = "minLength") String minLength,
			@RequestParam(value = "maxLength") String maxLength, @RequestParam(value = "emoji") String emoji)
			throws MissingServletRequestParameterException, JsonProcessingException, BadRangeValueException,
			BadValueException, BadStringException {

		ArrayList<FacebookPost> array = JSONManager.JSONParser(JSONManager.readURL());
		ArrayList<FacebookPost> filteredArray = Filtering.FilteredPostsByParam(array, minLength, maxLength, emoji);
		Statistics mystats = new Statistics(filteredArray, array);
		return new ResponseEntity<>(mystats, HttpStatus.OK);
	}

	@RequestMapping(value = "/filters", method = { RequestMethod.POST, RequestMethod.PUT })
	/**
	 * It allows user to do "/filters" call
	 * 
	 * @param filter the filter imported by body in POST request
	 * @return list of posts that satisfies filters parameters
	 */
	public ResponseEntity<Object> getFilters(@RequestBody Filters filter)
			throws BadValueException, BadRangeValueException {
		ArrayList<FacebookPost> array = JSONManager.JSONParser(JSONManager.readURL());
		filter.ReadValues(array);
		ArrayList<FacebookPost> filteredArray = Filtering.FilteredPosts(array, filter);
		return new ResponseEntity<>(filteredArray, HttpStatus.OK);
	}

}
