/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.model;

import java.util.ArrayList;

public class ArrayListFacebookPost extends FacebookPost {
	/**
	 * ArrayList of FacebookPost
	 */
	private ArrayList<FacebookPost> myar;

	/**
	 * Basic constructor
	 **/
	public ArrayListFacebookPost() {
		myar = new ArrayList<FacebookPost>();

	}

	/**
	 * Constructor with fields
	 **/
	public ArrayListFacebookPost(ArrayList<FacebookPost> myar) {
		this.myar = myar;

	}

	/**
	 * @return the myar
	 */
	public ArrayList<FacebookPost> getMyar() {
		return myar;
	}

	/**
	 * @param myar the myar to set
	 */
	public void setMyar(ArrayList<FacebookPost> myar) {
		this.myar = myar;
	}

	@Override
	public String toString() {
		return "Posts:\n" + myar;
	}

	/**
	 * @param post the post to add in the ArrayList This method provide to add a
	 *             post in the ArrayList
	 */
	public void addPost(FacebookPost post) {
		FacebookPost ps = new FacebookPost(post.getId(), post.getMessage(), post.getShares(), post.getReactions());
		myar.add(ps);
	}

	/**
	 * @param post the post to remove from ArrayList This method provide to remove a
	 *             post from ArrayList identified by it's Id
	 */
	public void removePost(FacebookPost post) {
		int i = 0;
		FacebookPost ps = new FacebookPost();
		while (i != myar.size()) {
			ps = myar.get(i);
			if (ps.getId().equals(post.getId()))
				myar.remove(i);
			i++;
		}

	}
}
