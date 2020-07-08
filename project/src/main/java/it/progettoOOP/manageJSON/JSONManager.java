/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.manageJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.progettoOOP.exceptions.BadValueException;
import it.progettoOOP.filters.Filters;
import it.progettoOOP.model.FacebookPost;

public class JSONManager {

	/**
	 * This method provides to open a connection by a specific URL object
	 * 
	 * @return JSONObject object contained query's results
	 */
	public static JSONObject readURL() {
		try {
			String myquery = "https://graph.facebook.com/me/posts?fields=id,shares,created_time,message,reactions.summary(1).limit(0)&access_token=EAAmlKB7cDMgBAGxIGbh829IzhKE7YxGhMQup3xcZCtIFvQq9OfMkF7iL7qUvX2E1rUdKBT8nVZCiOjuq4SdvfY1JmRT3Tua4jPh37qjLbP7bylKaVzrrpdkGAoaV5dKVZBICbYtiZCwDfHGSmnT5J4iHYxwcQsWliMMl8XVCi90AZCjXyxP42&limit=400";
			StringBuilder string = new StringBuilder();
			// Opening connection
			URL url = new URL(myquery);
			// Opening streams
			InputStreamReader in = new InputStreamReader(url.openStream());
			BufferedReader buffer = new BufferedReader(in);
			String line = "";
			while ((line = buffer.readLine()) != null) {
				string.append(line);
			}
			// Closing buffer streams
			in.close();
			buffer.close();
			JSONObject json = new JSONObject(string.toString());
			return json;
		} catch (Exception e) {
			System.out.println("*** WARNING ***" + "\n*** CONNECTION NOT STARTED ***\n");
			return null;
		}
	}

	/**
	 * @param JSONObject This method parses the JSONObject returned by DownloadJSON,
	 *                   extracts details and putting them in a
	 *                   ArrayListFacebookPost object
	 * @return the list with all details ordered by this method
	 */
	public static ArrayList<FacebookPost> JSONParser(JSONObject json) throws JSONException {
		ArrayList<FacebookPost> list = new ArrayList<FacebookPost>();

		if (json != null) {
			JSONArray data = json.optJSONArray("data");
			if (data != null) {

				for (int i = 0; i < data.length(); i++) {

					FacebookPost post = new FacebookPost();
					try {
						post.setId(data.getJSONObject(i).getString("id"));
					} catch (JSONException e) {
						post.setId("no id");
					}

					try {
						post.setMessage(data.getJSONObject(i).getString("message"));
					} catch (JSONException e) {
						post.setMessage("no message");
					}

					try {
						JSONObject obj = (JSONObject) (data.getJSONObject(i).get("shares"));
						post.setShares(obj.getInt("count"));
					} catch (JSONException e) {
						post.setShares(0);
					}
					try {
						JSONObject obj = (JSONObject) (data.getJSONObject(i).get("reactions"));
						JSONObject app = (JSONObject) (obj.get("summary"));
						post.setReactions(app.getInt("total_count"));
					} catch (JSONException e) {
						post.setReactions(0);
					}
					list.add(post);
				}
			}
		}
		return list;
	}
	
	/**
	 * @param JSONObject This method parses the JSONObject returned by DownloadJSON,
	 *                   extracts details and putting them in a
	 *                   ArrayListFacebookPost object
	 * @return the list with all details ordered by this method
	 */
	public static ArrayList<FacebookPost> JSONParser(Filters json) throws JSONException {
			int maxLengthMess = 10000;
			JSONObject length=json.getLength().get("length");
			if ((int) length.get("max") < 0)
				throw new BadValueException();
			maxLengthMess = (int) length.get("max");


			int minLengthMess = 0;
			if ((int) length.get("min") < 0)
				throw new BadValueException();
			minLengthMess = (int) length.get("min");

			int maxShares = 10000;
			if ((int) shares.get("max") < 0)
				throw new BadValueException();
			maxShares = (int) length.get("max");

			int minShares = 0;
			if ((int) shares.get("min") < 0)
				throw new BadValueException();
			minShares = (int) length.get("min");

			int maxReactions = 10000;
			if ((int) reactions.get("max") < 0)
				throw new BadValueException();
			maxReactions = (int) length.get("max");


			int minReactions = 0;
			if ((int) reactions.get("min") < 0)
				throw new BadValueException();
			minReactions = (int) reactions.get("min");

					list.add(post);
				}
			}
		}
		return list;
	}

	/**
	 * @param ArrayListFacebookPost This method parses the ArrayListFacebookPost to
	 *                              String formatted on JSON
	 * @return the JSON string that contains all ArrayListFacebookPost's details
	 */
	public static String JSONGenerator(ArrayList<FacebookPost> array) throws JsonProcessingException {
		String json = "";
		if (array != null) {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(array);
		}
		return json;
	}

}
