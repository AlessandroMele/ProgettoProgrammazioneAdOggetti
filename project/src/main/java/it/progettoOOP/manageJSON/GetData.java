package it.progettoOOP.manageJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GetData {
	//private String url = "https://graph.facebook.com/me/posts?fields=shares,message&access_token=EAAmlKB7cDMgBAGxIGbh829IzhKE7YxGhMQup3xcZCtIFvQq9OfMkF7iL7qUvX2E1rUdKBT8nVZCiOjuq4SdvfY1JmRT3Tua4jPh37qjLbP7bylKaVzrrpdkGAoaV5dKVZBICbYtiZCwDfHGSmnT5J4iHYxwcQsWliMMl8XVCi90AZCjXyxP42";

	public static String leggiURL() throws Exception {
		String url = "https://graph.facebook.com/me/posts?fields=shares,message&access_token=EAAmlKB7cDMgBAGxIGbh829IzhKE7YxGhMQup3xcZCtIFvQq9OfMkF7iL7qUvX2E1rUdKBT8nVZCiOjuq4SdvfY1JmRT3Tua4jPh37qjLbP7bylKaVzrrpdkGAoaV5dKVZBICbYtiZCwDfHGSmnT5J4iHYxwcQsWliMMl8XVCi90AZCjXyxP42";
	    StringBuilder stringa = new StringBuilder();
	    URL url1 = new URL(url);
	    InputStreamReader in = new InputStreamReader(url1.openStream());
	    BufferedReader buffer = new BufferedReader(in);
	    String line;
	    while ((line = buffer.readLine()) != null) {
	        stringa.append(line);
	    	}
	    System.out.println(stringa);
	    return stringa.toString();
	    }
}
