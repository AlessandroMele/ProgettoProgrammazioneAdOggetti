package it.progettoOOP.manageJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import it.progettoOOP.model.*;

public class ParseJSON {
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
						post.setMessage("no message");
					}

					try {
						JSONObject obj = (JSONObject) (data.getJSONObject(i).get("shares"));
						post.setShares(obj.getInt("count"));
					} catch (JSONException e) {
						post.setShares(0);
					}

					list.addPost(post);
				}
			}
		}
		return list;
	}
}
