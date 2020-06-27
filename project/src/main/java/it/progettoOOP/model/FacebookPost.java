package it.progettoOOP.model;

public class FacebookPost {
	private String Id;
	private String message;
	private String shares;

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

	public String getShares() {
		return shares;
	}

	public void setShares(String shares) {
		this.shares = shares;
	}
	public FacebookPost() {
		Id = "";
		message= "";
		shares = "";
	}
	public FacebookPost(String id, String message, String shares) {
		super();
		Id = id;
		this.message = message;
		this.shares = shares;
	}

	@Override
	public String toString() {
		return "FacebookPost [\nId=" + Id + ", message=" + message + ", shares=" + shares + "]";
	}

}
