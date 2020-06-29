/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.model;

public class FacebookPost {
	/**
	 * Identifier of the post
	 */
	private String Id;
	/**
	 * Message written by user on the post
	 */
	private String message;
	/**
	 * Number of total shares by other user of the post
	 */
	private int shares;
	/**
	 * Number of total reactions by other user of the post
	 */
	private int reactions;

	/**
	 * Basic constructor
	 */
	public FacebookPost() {
		Id = "no identifier";
		this.message = "no message";
		this.shares = 0;
		this.reactions = 0;
	}

	/**
	 * Constructor with fields
	 */
	public FacebookPost(String id, String message, int shares, int reactions) {
		Id = id;
		this.message = message;
		this.shares = shares;
		this.reactions = reactions;
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
	public int getShares() {
		return shares;
	}

	/**
	 * @param shares the shares to set
	 */
	public void setShares(int shares) {
		this.shares = shares;
	}

	/**
	 * @return the reactions
	 */
	public int getReactions() {
		return reactions;
	}

	/**
	 * @return the message's length
	 */
	public Integer getLengthMessage() {
		return message.length();
	}

	/**
	 * @param reactions the reactions to set
	 */
	public void setReactions(int reactions) {
		this.reactions = reactions;
	}

	/**
	 * Print post's details
	 */
	@Override
	public String toString() {
		return "\nPost: Id=" + Id + ", message=" + message + ", shares=" + shares + ", reactions=" + reactions;
	}

}