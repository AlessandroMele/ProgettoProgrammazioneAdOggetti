/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.filters;

import java.util.ArrayList;

import it.progettoOOP.exceptions.BadValueException;
import it.progettoOOP.model.FacebookPost;

public class Filtering {

	/**
	 * @param array   the array to filter
	 * @param options the body of the get request
	 * @return the array filtered
	 * @throws BadValueException
	 *
	 */
	public static ArrayList<FacebookPost> FilteredPosts(ArrayList<FacebookPost> array, Filters options)
			throws BadValueException {
		ArrayList<FacebookPost> arrayfil = new ArrayList<FacebookPost>();

		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getLengthMessage() <= options.getMaxLengthMess()
					&& array.get(i).getLengthMessage() >= options.getMinLengthMess()
					&& array.get(i).getNumShares() <= options.getMaxShares()
					&& array.get(i).getNumShares() >= options.getMinShares()
					&& array.get(i).getNumReactions() <= options.getMaxReactions()
					&& array.get(i).getNumReactions() >= options.getMinReactions())
				arrayfil.add(array.get(i));
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
	public static ArrayList<FacebookPost> FilteredPostsByParam(ArrayList<FacebookPost> array, int minLength,
			int maxLength, String emoji) {
		ArrayList<FacebookPost> arrayfil = new ArrayList<FacebookPost>();
		boolean emoticon = false;
		// convert lower case string to upper case string
		emoji.toUpperCase();
		if (emoji.contains("TRUE") || emoji.contains("FALSE")) {
			if (emoji.contains("TRUE"))
				emoticon = true;
			else
				emoticon = false;
			for (int i = 0; i < array.size(); i++) {
				if (array.get(i).getLengthMessage() <= maxLength && array.get(i).getLengthMessage() >= minLength
						&& array.get(i).containsEmoji() == emoticon)
					arrayfil.add(array.get(i));
			}
		} else {
			// if emoji string is not TRUE or FALSE, filter validates either cases.
			for (int i = 0; i < array.size(); i++) {
				if (array.get(i).getLengthMessage() <= maxLength && array.get(i).getLengthMessage() >= minLength)
					arrayfil.add(array.get(i));
			}
		}
		return arrayfil;
	}

}
