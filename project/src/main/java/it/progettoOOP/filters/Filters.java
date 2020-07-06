/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.filters;

import it.progettoOOP.exceptions.BadValueException;
import it.progettoOOP.model.ArrayListFacebookPost;

public class Filters {

	/**
	 * @param array   the array to filter
	 * @param options the body of the get request
	 * @return the array filtered
	 * @throws BadValueException 
	 *
	 */
	public static ArrayListFacebookPost FilteredPosts(ArrayListFacebookPost array, FiltersModel options) throws BadValueException {
		ArrayListFacebookPost arrayfil = new ArrayListFacebookPost();

		for (int i = 0; i < array.getSize(); i++) {
			if (array.getPost(i).getLengthMessage() <= options.getMaxLengthMess()
					&& array.getPost(i).getLengthMessage() >= options.getMinLengthMess()
					&& array.getPost(i).getNumShares() <= options.getMaxShares()
					&& array.getPost(i).getNumShares() >= options.getMinShares()
					&& array.getPost(i).getNumReactions() <= options.getMaxReactions()
					&& array.getPost(i).getNumReactions() >= options.getMinReactions())
				arrayfil.addPost(array.getPost(i));
		}
		return arrayfil;
	}

	/**
	 * @param array      the array to filter
	 * @param minLength  the minimum length of the post
	 * @param mmaxLength the maximum length of the post
	 * @param emoji      for checking if a message must contains or not emojis
	 * @return the array filtered
	 *
	 */
	public static ArrayListFacebookPost FilteredPostsByParam(ArrayListFacebookPost array, int minLength, int maxLength,String emoji) {
		ArrayListFacebookPost arrayfil = new ArrayListFacebookPost();
		if(emoji.contains("true")||emoji.contains("TRUE")||emoji.contains("false")||emoji.contains("FALSE")) {
			boolean emoticon;
			if(emoji.contains("true")||emoji.contains("TRUE")) emoticon =true;
				else emoticon = false;
		for (int i = 0; i < array.getSize(); i++) {
			if (array.getPost(i).getLengthMessage() <= maxLength && array.getPost(i).getLengthMessage() >= minLength
					&& array.getPost(i).containsEmoji() == emoticon)
				arrayfil.addPost(array.getPost(i));
		}
		}
		else {
			for (int i = 0; i < array.getSize(); i++) {
				if (array.getPost(i).getLengthMessage() <= maxLength && array.getPost(i).getLengthMessage() >= minLength)
					arrayfil.addPost(array.getPost(i));
			}
		}
		return arrayfil;
	}

}
