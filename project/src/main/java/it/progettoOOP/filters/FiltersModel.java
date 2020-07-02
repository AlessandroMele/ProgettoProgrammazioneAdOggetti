package it.progettoOOP.filters;


import org.json.simple.JSONObject;

public class FiltersModel {
	private boolean descrizione;
	private JSONObject length;
	private JSONObject shares;
	private boolean emoji;
	private String  minmess;
	private String maxmess;
	private String  minshares;
	private String maxshares;
	
	public FiltersModel() {
		//this.length = length;
		this.descrizione = false;
		this.emoji = false;
		this.minmess = "";
		this.maxmess ="";
		this.minshares = "";
		this.maxshares = "";
		
	}
	
	public Boolean getDescrizione() {
		return descrizione;
	}
	
	public boolean getEmoji() {
		return emoji;
	}
	
	public JSONObject getLength() {
		return length;
	}
	
	public JSONObject getShares() {
		return shares;
	}
	
	public String getMinMess() {
		minmess =  (String) length.get("min");
		return minmess ;
	}
	
	public String getMaxMess() {
		maxmess =  (String) length.get("max");
		return maxmess ;
	}
	
	public String getMinShares() {
		minshares =  (String) shares.get("mins");
		return minshares ;
	}
	
	public String getMaxShares() {
		maxshares =  (String) shares.get("maxs");
		return maxshares ;
	}
	
}
