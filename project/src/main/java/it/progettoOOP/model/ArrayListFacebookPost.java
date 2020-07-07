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
	private ArrayList<FacebookPost> arrayList;

	/**
	 * Basic constructor
	 **/
	public ArrayListFacebookPost() {
		arrayList = new ArrayList<FacebookPost>();

	}

	/**
	 * Constructor with fields
	 **/
	public ArrayListFacebookPost(ArrayList<FacebookPost> myar) {
		this.arrayList = myar;

	}

	/**
	 * @return the ArrayList<FacebookPost> arrayList
	 */
	public ArrayList<FacebookPost> getArrayList() {
		return arrayList;
	}

	/**
	 * @param ArrayList
	 * @return ArrayList dimension
	 */
	public int getSize() {
		return arrayList.size();
	}

	/**
	 * @param index of a post
	 * @return the post contained on "i" position
	 */
	public FacebookPost getPost(int i) {
		return arrayList.get(i);
	}

	/**
	 * @return the total number of reactions of the ArrayListFacebookPost 
	 */
	public int getTotReactions() {
		int totalReactions = 0;
		for(int i=0;i< arrayList.size();i++) totalReactions = totalReactions + arrayList.get(i).getNumReactions();
		return totalReactions;
	}
	
	/**
	 * @return the total number of shares of the ArrayListFacebookPost 
	 */
	public int getTotShares() {
		int totalShares = 0;
		for(int i=0;i< arrayList.size();i++) totalShares = totalShares + arrayList.get(i).getNumShares();
		return totalShares;
	}
	
	/**
	 * @return true if ArrayListFacebookPost is empty
	 */
	public boolean isEmpty() {
		return arrayList.size() == 0;
	}

	/**
	 * @param post the post to add in the ArrayList This method provide to add a
	 *             post in the ArrayList
	 */
	public void addPost(FacebookPost post) {
		FacebookPost ps = new FacebookPost(post.getId(), post.getMessage(), post.getNumShares(),
				post.getNumReactions());
		arrayList.add(ps);
	}

	/**
	 * @param post the post to remove from ArrayList This method provide to remove a
	 *             post from ArrayList identified by it's Id
	 */
	public void removePost(FacebookPost post) {
		int i = 0;
		while (i != arrayList.size()) {
			if (arrayList.get(i).getId().equals(post.getId()))
				arrayList.remove(i);
			i++;
		}
	}
}
