/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.model;

/**
 * It represents the fundamental attributes/methods of post imported from call:
 * "/data"
 */
public class FacebookPost {
	/**
	 * Identifier of the post
	 */
	private String id;
	/**
	 * Message written by user on the post
	 */
	private String message;
	/**
	 * Number of total shares by other user of the post
	 */
	private int numShares;
	/**
	 * Number of total reactions by other user of the post
	 */
	private int numReactions;

	/**
	 * Basic constructor
	 */
	public FacebookPost() {
		id = "no id";
		message = "no message";
		numShares = 0;
		numReactions = 0;
	}

	/**
	 * Constructor using fields
	 */
	public FacebookPost(String id, String message, int numShares, int numReactions) {
		this.id = id;
		this.message = message;
		this.numShares = numShares;
		this.numReactions = numReactions;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	public void setNumShares(int numShares) {
		this.numShares = numShares;
	}

	/**
	 * @return the reactions
	 */
	public int getNumReactions() {
		return numReactions;
	}

	/**
	 * It counts message's character, if message is "no message" it returns 0
	 * 
	 * @return the message's length
	 */
	public int LengthMessage() {
		if (message.equals("no message"))
			return 0;
		return message.length();
	}

	/**
	 * @param reactions the reactions to set
	 */
	public void setNumReactions(int numReactions) {
		this.numReactions = numReactions;
	}

	/**
	 * It checks if a message contains or not emoji
	 * 
	 * @return true if message contains emoji
	 */
	public boolean ContainsEmoji() {
		for (int i = 0; i < message.length(); i++)
			if (i < (message.length() - 1))
				if (Character.isSurrogatePair(message.charAt(i), message.charAt(i + 1)))
					return true;
		return false;
	}
}
