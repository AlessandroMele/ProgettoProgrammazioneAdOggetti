package it.progettoOOP.model;

import java.util.ArrayList;

public class ArrayListFacebookPost extends FacebookPost {
	private ArrayList<FacebookPost> myar;

	public ArrayList<FacebookPost> getMyar() {
		return myar;
	}

	public void setMyar(ArrayList<FacebookPost> myar) {
		this.myar = myar;
	}

	public ArrayListFacebookPost(ArrayList<FacebookPost> myar) {
		this.myar = myar;

	}

	public ArrayListFacebookPost() {
		myar = new ArrayList<FacebookPost>();

	}

	@Override
	public String toString() {
		return "ArrayListFacebookPost [myar=" + myar + "]";
	}

	public void addPost(FacebookPost post) {
		FacebookPost ps = new FacebookPost(post.getId(), post.getMessage(), post.getShares());
		myar.add(ps);
	}

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
