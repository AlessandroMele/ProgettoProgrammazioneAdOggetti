package it.progettoOOP.model;

public class FacebookPost {
	private String Id;
	private String message;
	private int shares;

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
	public FacebookPost() {
		Id = "";
		message= "";
		shares = 0;
	}
	public FacebookPost(String id, String message, int shares) {
		super();
		Id = id;
		this.message = message;
		this.shares = shares;
	}

	@Override
	public String toString() {
		return "FacebookPost [Id=" + Id + ", message=" + message + ", shares=" + shares + "]";
	}

}
