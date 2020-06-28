package it.progettoOOP.model;

public class FacebookPost {
	private String Id;
	private String message;
	private int shares;
	private int reactions;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getReactions() {
		return reactions;
	}

	public void setReactions(int reactions) {
		this.reactions = reactions;
	}

	public FacebookPost() {
		Id = "";
		message = "";
		shares = 0;
		reactions = 0;
	}

	public FacebookPost(String id, String message, int shares, int reactions) {
		Id = id;
		this.message = message;
		this.shares = shares;
		this.reactions = reactions;
	}

	@Override
	public String toString() {
		return "\nPost: Id=" + Id + ", Message=" + message + ", Shares=" + shares + ", Reactions=" + reactions;
	}

}
