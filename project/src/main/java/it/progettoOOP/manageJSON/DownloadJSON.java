/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.manageJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

public class DownloadJSON {
	/**
	 * This method provides to open a connection by a specific URL object
	 * 
	 * @return JSONObject object contained query's results
	 */
	public static JSONObject readURL(){
		try {
			String myquery = "https://graph.facebook.com/me/posts?fields=id,shares,created_time,message,reactions.summary(1).limit(0)&access_token=EAAmlKB7cDMgBAGxIGbh829IzhKE7YxGhMQup3xcZCtIFvQq9OfMkF7iL7qUvX2E1rUdKBT8nVZCiOjuq4SdvfY1JmRT3Tua4jPh37qjLbP7bylKaVzrrpdkGAoaV5dKVZBICbYtiZCwDfHGSmnT5J4iHYxwcQsWliMMl8XVCi90AZCjXyxP42&limit=400";
			StringBuilder string = new StringBuilder();
			// Opening connection
			URL url = new URL(myquery);
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
			// e.printStackTrace(e);
			System.out.println("*** WARNING ***" + "\n*** CONNECTION NOT STARTED ***\n");
			return null;
		}
	}
}
