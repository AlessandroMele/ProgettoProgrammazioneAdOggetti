/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.manageJSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.progettoOOP.model.*;

public class GenerateJSON {
	/**
	 * @param ArrayListFacebookPost This method parses the ArrayListFacebookPost to
	 *                              JSON String,
	 * @return the JSON string that contains all ArrayListFacebookPost's details
	 */
	public String JSONGenerator(ArrayListFacebookPost list) throws Exception {
		String json = "";
		if (list != null) {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(list);
		}
		return json;
	}
}
