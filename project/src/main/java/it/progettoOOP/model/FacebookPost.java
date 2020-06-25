package it.progettoOOP.model;

import java.time.LocalDateTime;

public class FacebookPost {
	String Id;
	String message;
	LocalDateTime creationDate;
	int shares;

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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public FacebookPost(String id, String message, LocalDateTime creationDate, int shares) {
		super();
		Id = id;
		this.message = message;
		this.creationDate = creationDate;
		this.shares = shares;
	}

	@Override
	public String toString() {
		return "FacebookPost [Id=" + Id + ", message=" + message + ", creationDate=" + creationDate + ", shares="
				+ shares + "]";
	}

}
