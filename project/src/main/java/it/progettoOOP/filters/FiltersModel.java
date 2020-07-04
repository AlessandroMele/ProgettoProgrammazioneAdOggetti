package it.progettoOOP.filters;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class FiltersModel {
	private JSONObject length;
	private JSONObject shares;
	private JSONObject reactions;
	private boolean viewMessage;

	public FiltersModel() {
		try {
			this.length = length;
		} catch (HttpMessageNotReadableException e) {
			this.length = new JSONObject();
		}
		try {
			this.shares = shares;
		} catch (HttpMessageNotReadableException e) {
			this.shares = new JSONObject();
		}
		try {
			this.reactions = reactions;
		} catch (HttpMessageNotReadableException e) {
			this.reactions = new JSONObject();
		}
		try {
			this.viewMessage = false;
		} catch (HttpMessageNotReadableException e) {
			this.viewMessage = false;
		}
	}

	public Boolean getViewMessage() {
		return viewMessage;
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

	public int getMinLengthMess() {
		try {
			int minLengthMess = (int) length.get("min");
			return minLengthMess;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public int getMaxLengthMess() {
		try {
			int maxLengthMess = (int) length.get("max");
			return maxLengthMess;
		} catch (NullPointerException e) {
			return 100000;
		}
	}

	public int getMinShares() {
		try {
			int minShares = (int) shares.get("min");
			return minShares;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public int getMaxShares() {
		try {
			int maxShares = (int) shares.get("max");
			return maxShares;
		} catch (NullPointerException e) {
			return 100000;
		}
	}

	public int getMinReactions() {
		try {
			int minReactions = (int) reactions.get("min");
			return minReactions;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public int getMaxReactions() {
		try {
			int maxReactions = (int) reactions.get("max");
			return maxReactions;
		} catch (NullPointerException e) {
			return 100000;
		}
	}

}
