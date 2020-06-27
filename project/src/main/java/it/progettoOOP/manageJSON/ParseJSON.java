package it.progettoOOP.manageJSON;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import it.progettoOOP.model.*;

public class ParseJSON {
	public static ArrayList<FacebookPost> JSONParser(JSONObject json) throws JSONException {
		ArrayList<FacebookPost> list = new ArrayList<FacebookPost>();

		if (json != null) {
			JSONArray data = json.optJSONArray("data");
			if (data != null) {

				for (int i = 0; i < data.length(); i++) {

					FacebookPost post = new FacebookPost();
					post.setId(data.getJSONObject(i).getString("id"));
					
					try {
						post.setMessage(data.getJSONObject(i).getString("message"));}
					catch(NullPointerException e)					{e.printStackTrace();}
					finally {post.setMessage("no comment available");}
					post.setShares(1);

					list.add(post);
				}
			}
		}
		return list;
	}
}
