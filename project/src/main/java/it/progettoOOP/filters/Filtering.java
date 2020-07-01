package it.progettoOOP.filters;

import it.progettoOOP.model.ArrayListFacebookPost;

public class Filtering {

	public ArrayListFacebookPost FilteredPosts(ArrayListFacebookPost array, FiltersModel options) {
		ArrayListFacebookPost arrayfil = new ArrayListFacebookPost();
		for (int i=0;i< array.getSize(); i++) {
			if (options.getDescrizione()== true) {
				if (array.getPost(i).getLengthMessage() < options.getMax() && array.getPost(i).getLengthMessage() > options.getMin()) 
				arrayfil.addPost(array.getPost(i));	
				}
			}
		
		return arrayfil;
	}
}
