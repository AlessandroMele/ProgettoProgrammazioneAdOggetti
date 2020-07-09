package it.progettoOOP.project;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import it.progettoOOP.exceptions.BadRangeValueException;

public class FiltersTests {
	
	@BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        assertThrows(BadRangeValueException.class, ()->Filtering.FilteredPostsByParam("emoji","","TRUE"));
    }
}
