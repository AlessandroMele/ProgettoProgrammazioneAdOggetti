/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class FacebookPost {
	/**
	 * Identifier of the post
	 */
	protected String Id;
	/**
	 * Message written by user on the post
	 */
	protected String message;
	/**
	 * Number of total shares by other user of the post
	 */
	protected int numShares;
	/**
	 * Number of total reactions by other user of the post
	 */
	protected int numReactions;

	/**
	 * Basic constructor
	 */
	public FacebookPost() {
		Id = "no identifier";
		this.message = "no message";
		this.numShares = 0;
		this.numReactions = 0;
	}

	/**
	 * Constructor with fields
	 */
	public FacebookPost(String id, String message, int numShares, int numReactions) {
		Id = id;
		this.message = message;
		this.numShares = numShares;
		this.numReactions = numReactions;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}

	/**
	 * @return the message
	 */

	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the shares
	 */
	public int getNumShares() {
		return numShares;
	}

	/**
	 * @param shares the shares to set
	 */
	public void setShares(int numShares) {
		this.numShares = numShares;
	}

	/**
	 * @return the reactions
	 */
	public int getNumReactions() {
		return numReactions;
	}

	/**
	 * @return the message's length
	 */
	public int getLengthMessage() {
		if (message.equals("no message"))
			return 0;
		return message.length();
	}

	/**
	 * @param reactions the reactions to set
	 */
	public void setReactions(int numReactions) {
		this.numReactions = numReactions;
	}

	public boolean FindEmoji() {
		//String message = post.getMessage();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			if (i < (message.length() - 1)) {
				if (Character.isSurrogatePair(message.charAt(i), message.charAt(i + 1))) {
					sb.append(message.charAt(i));
					i++;
					sb.append(message.charAt(i));
					sb.append(",");
					continue;
				}
			}
		}
		if (sb.toString().equals(""))
			return false;
		else
			return true;
	}

	/**
	 * Print post's details
	 */
	@Override
	public String toString() {
		return "\nPOST: \n   ID=" + Id + "\n   MESSAGE =" + message + "\n   SHARES =" + numShares + "\n   REACTIONS ="
				+ numReactions + "\n";
	}
}