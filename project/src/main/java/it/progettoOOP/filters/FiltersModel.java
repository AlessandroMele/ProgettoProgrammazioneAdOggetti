package it.progettoOOP.filters;


import org.json.simple.JSONObject;

public class FiltersModel {
	private boolean descrizione;
	private JSONObject length;
	private JSONObject shares;
	private JSONObject reactions;
	private boolean emoji;
	
	
	public FiltersModel() {
		this.length = length;
		this.shares = shares;
		this.reactions = reactions;
		this.descrizione = false;
		this.emoji = false;
		
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
	
	public JSONObject getReactions() {
		return reactions;
	}
	
	public int getMinMess() {
		int minmess =  (int) length.get("min");
		return minmess ;
	}
	
	public int getMaxMess() {
		int maxmess =  (int) length.get("max");
		return maxmess ;
	}
	
	public int getMinShares() {
		int minshares =  (int) shares.get("min");
		return minshares ;
	}
	
	public int getMaxShares() {
		int maxshares =  (int) shares.get("max");
		return maxshares ;
	}
	
	public int getMinReactions() {
		int minreactions =  (int) reactions.get("min");
		return minreactions ;
	}
	
	public int getMaxReactions() {
		int maxreactions =  (int) reactions.get("max");
		return maxreactions ;
	}
	
}
