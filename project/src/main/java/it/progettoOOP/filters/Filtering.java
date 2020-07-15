/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.filters;

import java.util.ArrayList;
import it.progettoOOP.exceptions.*;
import it.progettoOOP.model.FacebookPost;
import it.progettoOOP.stats.Statistics;

/**
 * Contains Filtering methods
 */
public class Filtering {

	/**
	 * @param <ArrayList>FacebookPost the array to filter
	 * @param options                 the body of POST request
	 * @return the array filtered
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 *
	 */
	public static ArrayList<FacebookPost> FilteredPosts(ArrayList<FacebookPost> array, Filters filter)
			throws BadValueException, BadRangeValueException {
		ArrayList<FacebookPost> arrayfil = new ArrayList<FacebookPost>();
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).LengthMessage() >= filter.MinLength() && array.get(i).LengthMessage() <= filter.MaxLength()
					&& array.get(i).getNumShares() >= filter.MinShares()
					&& array.get(i).getNumShares() <= filter.MaxShares()
					&& array.get(i).getNumReactions() >= filter.MinReactions()
					&& array.get(i).getNumReactions() <= filter.MaxReactions())
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
	public static ArrayList<FacebookPost> FilteredPostsByParam(ArrayList<FacebookPost> array, String minLength,
			String maxLength, String emoji) throws BadRangeValueException, BadValueException, BadStringException {
		ArrayList<FacebookPost> arrayfil = new ArrayList<FacebookPost>();
		boolean emoticon = false;
		Statistics mystat = new Statistics();
		int min = 0;
		int max = 0;

		if (minLength.equals(""))
			min = mystat.MinLengthMessage(array);
		else
			min = Integer.parseInt(minLength);
		if (min < 0)
			throw new BadValueException();

		if (maxLength.equals(""))
			max = mystat.MaxLengthMessage(array);
		else
			max = Integer.parseInt(maxLength);
		if (max < 0)
			throw new BadValueException();

		if (max < min)
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
			// takes all posts
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).LengthMessage() <= max && array.get(i).LengthMessage() >= min)
					arrayfil.add(array.get(i));
		} else
			// If String is not one of three cases, exception starts
			throw new BadStringException();
		return arrayfil;
	}
}