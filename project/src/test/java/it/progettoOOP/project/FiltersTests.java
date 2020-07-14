/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.project;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.*;

import it.progettoOOP.exceptions.*;
import it.progettoOOP.filters.*;
import it.progettoOOP.model.FacebookPost;

public class FiltersTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void BadRangeValueExceptiontest() {
		ArrayList<FacebookPost> testArray = new ArrayList<FacebookPost>();
		FacebookPost testPost = new FacebookPost("id", "message", 0, 20);
		testArray.add(testPost);
		assertThrows(BadRangeValueException.class,
				() -> Filtering.FilteredPostsByParam(testArray, 20, 10, "notSpecified"));
	}

	@Test
	public void BadStringException() {
		ArrayList<FacebookPost> testArray = new ArrayList<FacebookPost>();
		FacebookPost testPost = new FacebookPost("id", "message", 0, 20);
		testArray.add(testPost);
		assertThrows(BadStringException.class, () -> Filtering.FilteredPostsByParam(testArray, 0, 100, "prova"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void BadValueException() {
		ArrayList<FacebookPost> testArray = new ArrayList<FacebookPost>();
		FacebookPost testPost = new FacebookPost("id", "message", 0, 20);
		testArray.add(testPost);
		JSONObject length = new JSONObject();
		length.put("min", -10);
		Filters filter = new Filters(length);
		assertThrows(BadValueException.class, () -> Filtering.FilteredPosts(testArray, filter));
	}
}