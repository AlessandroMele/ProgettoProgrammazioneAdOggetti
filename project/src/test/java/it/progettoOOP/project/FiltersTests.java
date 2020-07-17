/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;

import it.progettoOOP.exceptions.*;
import it.progettoOOP.filters.*;
import it.progettoOOP.model.FacebookPost;
import it.progettoOOP.stats.Statistics;

/**
 * It contains some tests for testing Filtering methods
 */
public class FiltersTests {
	private ArrayList<FacebookPost> testArray;

	@BeforeEach
	void setUp() throws Exception {
		testArray = new ArrayList<FacebookPost>();
		FacebookPost testPost = new FacebookPost("testId", "testMessage", 0, 20);
		FacebookPost testPost1 = new FacebookPost("testId", "", 0, 40);
		testArray.add(testPost);
		testArray.add(testPost1);
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
		 * It tests if String value in parameter "emoji" is a correct String
		 */
		assertThrows(BadStringException.class, () -> Filtering.FilteredPostsByParam(testArray, "0", "100", "prova"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void BadValueExceptionTest() throws BadValueException, BadRangeValueException {
		/**
		 * It tests if value of minimum length message is a negative number
		 */
		JSONObject length = new JSONObject();
		length.put("min", -10);
		Filters filter = new Filters(length);
		assertThrows(BadValueException.class, () -> filter.ReadValues(testArray));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void ParsingTest() throws BadValueException, BadRangeValueException {
		/**
		 * It tests if return correct value from JSONObject "min"
		 */
		JSONObject length = new JSONObject();
		length.put("max", 10);
		Filters filter = new Filters(length);
		filter.ReadValues(testArray);
		assertEquals(10, filter.getLengthValues().getMax());
	}

	@Test
	public void StatisticsTest() throws BadValueException, BadRangeValueException {
		/**
		 * It tests statistics values about a field contained on ArrayList<FacebookPost>
		 */
		ArrayList<FacebookPost> necessary = new ArrayList<FacebookPost>();
		FacebookPost post = new FacebookPost("ciao", "mess", 1, 5);
		necessary.add(post);
		Statistics testStats = new Statistics(testArray);
		Statistics testStats1 = new Statistics(testArray, necessary);

		assertEquals(11, testStats.getMaxLengthMessage());
		assertEquals(0, testStats.getMinLengthMessage());

		assertEquals(60, testStats1.getReactions().getSum());
		assertEquals(40, testStats1.getReactions().getMax());
		assertEquals(20, testStats1.getReactions().getMin());
		assertEquals(30, (int) testStats1.getReactions().getAverage());

	}
}