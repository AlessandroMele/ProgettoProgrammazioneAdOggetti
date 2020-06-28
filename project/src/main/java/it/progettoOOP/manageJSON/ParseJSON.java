/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.manageJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import it.progettoOOP.model.*;

public class ParseJSON {
	/**
	 * @param JSONObject This method parses the JSONObject returned by DownloadJSON,
	 *                   extracts details and putting them in a
	 *                   ArrayListFacebookPost object
	 * @return the list with all details ordered by this method
	 */
	public static ArrayListFacebookPost JSONParser(JSONObject json) throws JSONException {
		ArrayListFacebookPost list = new ArrayListFacebookPost();

		if (json != null) { 
			JSONArray data = json.optJSONArray("data");
			if (data != null) {

				for (int i = 0; i < data.length(); i++) {

					FacebookPost post = new FacebookPost();
					post.setId(data.getJSONObject(i).getString("id"));

					try {
						post.setMessage(data.getJSONObject(i).getString("message"));
					} catch (JSONException e) {
						//e.printStackTrace();
						post.setMessage("no message");
					}

					try {
						JSONObject obj = (JSONObject) (data.getJSONObject(i).get("shares"));
						post.setShares(obj.getInt("count"));
					} catch (JSONException e) {
						//e.printStackTrace();
						post.setShares(0);
					}
					try {
						JSONObject obj = (JSONObject) (data.getJSONObject(i).get("reactions"));
						JSONObject app = (JSONObject) (obj.get("summary"));
						post.setReactions(app.getInt("total_count"));
					} catch (JSONException e) {
						//e.printStackTrace();
						post.setReactions(0);
					}

					list.addPost(post);
				}
			}
		}
		return list;
	}
}
