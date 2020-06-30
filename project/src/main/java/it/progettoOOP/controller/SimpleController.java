package it.progettoOOP.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.progettoOOP.manageJSON.JSONManager;
import it.progettoOOP.model.ArrayListFacebookPost;
import it.progettoOOP.stats.*;

@RestController
public class SimpleController {

	@RequestMapping(value = "/data", method = RequestMethod.GET)

	public ResponseEntity<Object> getPost() throws JSONException {
		JSONManager myd = new JSONManager();
		JSONManager myp = new JSONManager();
		JSONObject myobj = myd.readURL();
		ArrayListFacebookPost myarray = myp.JSONParser(myobj);
		return new ResponseEntity<>(myarray, HttpStatus.OK);
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)

	public ResponseEntity<Object> getStats() throws Exception {
		JSONManager myd = new JSONManager();
		Statistics myst = new Statistics();
		JSONManager myp = new JSONManager();
		JSONObject myobj = myd.readURL();
		ArrayListFacebookPost myarray = myp.JSONParser(myobj);
		return new ResponseEntity<>(myst.StatisticsReports(myarray), HttpStatus.OK);
	}

}