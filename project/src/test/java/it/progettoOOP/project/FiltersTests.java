/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.project;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;

import it.progettoOOP.exceptions.*;
import it.progettoOOP.filters.*;
import it.progettoOOP.model.FacebookPost;

/**
 * It contains some tests for testing Filtering methods
 */
public class FiltersTests {
	private ArrayList<FacebookPost> testArray;

	@BeforeEach
	void setUp() throws Exception {
		testArray = new ArrayList<FacebookPost>();
		FacebookPost testPost = new FacebookPost("id", "message", 0, 20);
		testArray.add(testPost);
		testArray.add(testPost);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void BadRangeValueExceptionTest() {
		/**
		 * It tests if range value of length message is a negative number
		 */
		assertThrows(BadRangeValueException.class,
				() -> Filtering.FilteredPostsByParam(testArray, "20", "10", "notSpecified"));
	}

	@Test
	public void BadStringExceptionTest() {
		/**
		 * It tests if String value in param "emoji" is a correct String
		 */
		assertThrows(BadStringException.class, () -> Filtering.FilteredPostsByParam(testArray, "0", "100", "prova"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void BadValueExceptionTest() {
		/**
		 * It tests if value of minimum length message is a negative number
		 */
		JSONObject length = new JSONObject();
		length.put("min", -10);
		Filters filter = new Filters(length);
		assertThrows(BadValueException.class, () -> Filtering.FilteredPosts(testArray, filter));
	}
}