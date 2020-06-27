package it.progettoOOP.manageJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

public class DownloadJSON {

	public static JSONObject readURL() throws Exception {
		String myquery = "https://graph.facebook.com/me/posts?fields=id,shares,created_time,message&access_token=EAAmlKB7cDMgBAGxIGbh829IzhKE7YxGhMQup3xcZCtIFvQq9OfMkF7iL7qUvX2E1rUdKBT8nVZCiOjuq4SdvfY1JmRT3Tua4jPh37qjLbP7bylKaVzrrpdkGAoaV5dKVZBICbYtiZCwDfHGSmnT5J4iHYxwcQsWliMMl8XVCi90AZCjXyxP42&limit=200\r\n";
		StringBuilder string = new StringBuilder();
		URL url = new URL(myquery);
		InputStreamReader in = new InputStreamReader(url.openStream());
		BufferedReader buffer = new BufferedReader(in);
		String line;
		while ((line = buffer.readLine()) != null) {
			string.append(line);
		}
		in.close();
		buffer.close();
		System.out.println(string);
		JSONObject json = new JSONObject(string.toString());
		return json;
	}
}
