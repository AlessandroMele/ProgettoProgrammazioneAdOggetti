package it.progettoOOP.stats;

import java.util.ArrayList;

import org.json.JSONException;

import it.progettoOOP.model.ArrayListFacebookPost;
import it.progettoOOP.model.FacebookPost;

public class statistics {
	
	static ArrayList<Integer> likes;
	static int media=0;
	static int somma = 0;
	static int massimo =0;
	static int minimo=0;
	static int maxleng =0;

	public static Integer media(ArrayListFacebookPost ar) {
		ArrayList<FacebookPost> arrayfp = ar.getMyar();
		likes = new ArrayList<Integer>();
		FacebookPost fp = new FacebookPost();
		fp = null; 
		int i=0;
		for(i=0; i< ar.getDimension(arrayfp) ;i++) {
			fp = ar.getPost(i);
			try {
				likes.add(fp.getReactions());
				somma = somma + likes.get(i);
			}catch (NullPointerException e) {
				//e.printStackTrace();
				System.out.println("nullPointerException");
			}
		}
		media = somma/ar.getDimension(arrayfp);
		return media;
	}
	
	public static Integer max(ArrayListFacebookPost ar) {
		ArrayList<FacebookPost> arrayfp = ar.getMyar();
		FacebookPost fp = new FacebookPost();
		fp = null; 
		int i=0;
		for(i=0; i< ar.getDimension(arrayfp) ;i++) {
			fp = ar.getPost(i);
			if(fp.getReactions()> massimo) {
				massimo = fp.getReactions();
			}
		}
		return massimo;
	}
	
	public static Integer min(ArrayListFacebookPost ar) {
		ArrayList<FacebookPost> arrayfp = ar.getMyar();
		FacebookPost fp = new FacebookPost();
		fp = null; 
		int i=0;
		for(i=0; i< ar.getDimension(arrayfp) ;i++) {
			fp = ar.getPost(i);
			if(fp.getReactions()< massimo) {
				minimo = fp.getReactions();
			}
		}
		return minimo;
	}
	
	public static Integer maxLeng(ArrayListFacebookPost ar) {
		ArrayList<FacebookPost> arrayfp = ar.getMyar();
		FacebookPost fp = new FacebookPost();
		fp = null; 
		int i=0;
		for(i=0; i< ar.getDimension(arrayfp) ;i++) {
			fp = ar.getPost(i);
			if(fp.getLengMess() > massimo) {
				maxleng = fp.getLengMess();
			}
		}
		return maxleng;
	}

}
