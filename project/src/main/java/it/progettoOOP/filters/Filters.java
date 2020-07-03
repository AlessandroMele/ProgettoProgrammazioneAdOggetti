package it.progettoOOP.filters;

import it.progettoOOP.model.ArrayListFacebookPost;

public class Filters {

	public ArrayListFacebookPost FilteredPosts(ArrayListFacebookPost array, FiltersModel options) {
		ArrayListFacebookPost arrayfil = new ArrayListFacebookPost();
		
		for (int i=0;i< array.getSize(); i++) {
			if (array.getPost(i).getLengthMessage() <= options.getMaxLengthMess() && array.getPost(i).getLengthMessage() >= options.getMinLengthMess()
				&& array.getPost(i).getNumShares() <= options.getMaxShares() && array.getPost(i).getNumShares() >= options.getMinShares()
				&& array.getPost(i).getNumReactions() <= options.getMaxReactions() && array.getPost(i).getNumReactions() >= options.getMinReactions()) 
				arrayfil.addPost(array.getPost(i));	
				}
	return arrayfil;
	}
	
}
