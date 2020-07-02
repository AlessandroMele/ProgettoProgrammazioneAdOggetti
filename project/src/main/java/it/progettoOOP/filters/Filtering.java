package it.progettoOOP.filters;

import java.util.ArrayList;

import it.progettoOOP.model.ArrayListFacebookPost;

public class Filtering {

	public ArrayListFacebookPost FilteredPosts(ArrayListFacebookPost array, FiltersModel options) {
		ArrayListFacebookPost arrayfil = new ArrayListFacebookPost();
		ArrayList<Integer> good1 = new ArrayList<Integer> ();
		ArrayList<Integer> good2 = new ArrayList<Integer> ();
		ArrayList<Integer> goodfinal = new ArrayList<Integer> ();
		
		for (int i=0;i< array.getSize(); i++) {
			if (array.getPost(i).getLengthMessage() <= options.getMaxMess() && array.getPost(i).getLengthMessage() >= options.getMinMess()) good1.add(i);	
				}
		
		for(int j=0; j< good1.size();j++) {
			if (array.getPost(j).getNumShares() <= options.getMaxShares() && array.getPost(j).getNumShares() >= options.getMinShares()) good2.add(j);
		}
		
		for (int m=0;m< good2.size(); m++) {
			if (array.getPost(m).getReactions() <= options.getMaxReactions() && array.getPost(m).getReactions() >= options.getMinReactions()) goodfinal.add(m);	
				}
		
		for (int z=0; z< goodfinal.size();z++) {
			arrayfil.addPost(array.getPost(goodfinal.get(z)));
		}
		
	return arrayfil;
	}
}
