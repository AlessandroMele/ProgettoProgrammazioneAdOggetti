/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.filters;

import java.util.ArrayList;

import it.progettoOOP.exceptions.BadRangeValueException;
import it.progettoOOP.exceptions.BadStringException;
import it.progettoOOP.exceptions.BadValueException;
import it.progettoOOP.model.FacebookPost;
import it.progettoOOP.stats.Statistics;

public class Filtering {

	/**
	 * @param <ArrayList>FacebookPost the array to filter
	 * @param options                 the body of the POST request
	 * @return the array filtered
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 *
	 */
	public static ArrayList<FacebookPost> FilteredPosts(ArrayList<FacebookPost> array, Filters filter)
			throws BadValueException, BadRangeValueException {
		ArrayList<FacebookPost> arrayfil = new ArrayList<FacebookPost>();
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).LengthMessage() >= filter.MinLength(array)
					&& array.get(i).LengthMessage() <= filter.MaxLength(array)
					&& array.get(i).getNumShares() >= filter.MinShares(array)
					&& array.get(i).getNumShares() <= filter.MaxShares(array)
					&& array.get(i).getNumReactions() >= filter.MinReactions(array)
					&& array.get(i).getNumReactions() <= filter.MaxReactions(array))
				arrayfil.add(array.get(i));
		}
		return arrayfil;
	}

	/**
	 * @param array      the <ArrayList>FacebookPost to filter
	 * @param minLength  the minimum length message of the post
	 * @param mmaxLength the maximum length message of the post
	 * @param emoji      for checking if a message contains or not emojis
	 * @return the array filtered
	 * @throws BadRangeValueException
	 * @throws BadValueException
	 * @throws BadStringException
	 *
	 */
	public static ArrayList<FacebookPost> FilteredPostsByParam(ArrayList<FacebookPost> array, int minLength,
			int maxLength, String emoji)
			throws BadRangeValueException, BadValueException, BadStringException, NumberFormatException {
		ArrayList<FacebookPost> arrayfil = new ArrayList<FacebookPost>();
		boolean emoticon = false;
		Statistics mystat = new Statistics();
		int min = 0;
		int max = 0;
		// "," is character that split String param
		// If there's only one value, by default it's the minimum
		try {
			// Minimum value is the first character
			min = minLength;
			if (min < 0)
				throw new BadValueException();
		} catch (NullPointerException e) {
			// If it's setted, by default is the maximum value of
			// length message searched in all posts
			min = mystat.MinLengthMessage(array);
		}

		try {
			// Maximum value is the second character
			max = maxLength;
			if (max < 0)
				throw new BadValueException();
		} catch (NullPointerException e) {
			// If it's setted, by default is the maximum value of
			// length message searched in all posts
			max = mystat.MaxLengthMessage(array);
		}
		// If it's not a positive value, exception starts
		if (maxLength < minLength)
			throw new BadRangeValueException();
		// Emoji control
		String EmojiUnsensitive = emoji.toUpperCase();
		if (EmojiUnsensitive.equals("TRUE") || EmojiUnsensitive.equals("FALSE")) {
			if (EmojiUnsensitive.equals("TRUE"))
				emoticon = true;
			else
				emoticon = false;
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).LengthMessage() <= max && array.get(i).LengthMessage() >= min
						&& array.get(i).ContainsEmoji() == emoticon)
					arrayfil.add(array.get(i));
		} else if (EmojiUnsensitive.equals("NOTSPECIFIED")) {
			// If String is "NOTSPECIFIED" (and others upper/lower case), by default it
			// takes either
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).LengthMessage() <= max && array.get(i).LengthMessage() >= min)
					arrayfil.add(array.get(i));
		} else
			throw new BadStringException();
		return arrayfil;
	}

}