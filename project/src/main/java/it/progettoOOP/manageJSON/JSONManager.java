/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.manageJSON;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import org.json.*;

import it.progettoOOP.model.FacebookPost;

/**
 * It contains methods for doing call and parsing call results
 */
public class JSONManager {

	/**
	 * It provides to open a connection by a specific URL
	 * 
	 * @return JSONObject object that contains query's results
	 */
	public static JSONObject readURL() {
		try {
			String myquery = "https://graph.facebook.com/me/posts?fields=id,shares,created_time,message,reactions.summary(1).limit(0)&access_token=EAAmlKB7cDMgBAGxIGbh829IzhKE7YxGhMQup3xcZCtIFvQq9OfMkF7iL7qUvX2E1rUdKBT8nVZCiOjuq4SdvfY1JmRT3Tua4jPh37qjLbP7bylKaVzrrpdkGAoaV5dKVZBICbYtiZCwDfHGSmnT5J4iHYxwcQsWliMMl8XVCi90AZCjXyxP42&limit=400";
			StringBuilder string = new StringBuilder();
			// Opening connection
			URL url = new URL(myquery);
			// Opening stream
			BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = "";
			while ((line = buffer.readLine()) != null) {
				string.append(line);
			}
			// Closing buffer stream
			buffer.close();
			JSONObject json = new JSONObject(string.toString());
			return json;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * It parses the JSONObject returned by DownloadJSON(), extracts details and put
	 * them on a <ArrayList>FacebookPost
	 * 
	 * @param JSONObject the JSONObject to parse
	 * @return the list with all details ordered by this method
	 */
	public static ArrayList<FacebookPost> JSONParser(JSONObject json) {
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
						post.setNumShares(obj.getInt("count"));
					} catch (JSONException e) {
						post.setNumShares(0);
					}
					try {
						JSONObject obj = (JSONObject) (data.getJSONObject(i).get("reactions"));
						JSONObject app = (JSONObject) (obj.get("summary"));
						post.setNumReactions(app.getInt("total_count"));
					} catch (JSONException e) {
						post.setNumReactions(0);
					}
					list.add(post);
				}
			}
		}
		return list;
	}
}
