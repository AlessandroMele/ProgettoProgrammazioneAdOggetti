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
			if (array.get(i).LengthMessage() <= filter.MaxLength() && array.get(i).LengthMessage() >= filter.MinLength()
					&& array.get(i).getNumShares() <= filter.MaxShares()
					&& array.get(i).getNumShares() >= filter.MinShares()
					&& array.get(i).getNumReactions() <= filter.MaxReactions()
					&& array.get(i).getNumReactions() >= filter.MinReactions())
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
	public static ArrayList<FacebookPost> FilteredPostsByParam(ArrayList<FacebookPost> array, String param,
			String emoji) throws BadRangeValueException, BadValueException, BadStringException, NumberFormatException {
		ArrayList<FacebookPost> arrayfil = new ArrayList<FacebookPost>();
		boolean emoticon = false;
		Statistics mystat = new Statistics();
		int minLength = 0;
		int maxLength = 0;
		// "," is character that split String param
		// If there's only one value, by default it's the minimum
		String[] rangeLength = param.split(",");
		try {
			// Minimum value is the first character
			String min = rangeLength[0];
			minLength = Integer.parseInt(min);
			if (minLength < 0)
				throw new BadValueException();
		} catch (Exception e) {
			// If it's not an integer value, by default is setted as the minimum value of
			// length message searched in all posts
			minLength = mystat.MinLengthMessage(array);
		}

		try {
			// Maximum value is the second character
			String max = rangeLength[1];
			maxLength = Integer.parseInt(max);
			if (maxLength < 0)
				throw new BadValueException();
		} catch (Exception e) {
			// If it's not an integer value, by default is setted as the maximum value of
			// length message searched in all posts
			maxLength = mystat.MaxLengthMessage(array);
		}
		// If it's not a positive value, exception starts
		if (maxLength < minLength)
			throw new BadRangeValueException();
		// Emoji control
		if (emoji.equals("TRUE") || emoji.equals("true") || emoji.equals("FALSE") || emoji.equals("false")) {
			if (emoji.equals("TRUE") || emoji.equals("true"))
				emoticon = true;
			else
				emoticon = false;
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).LengthMessage() <= maxLength && array.get(i).LengthMessage() >= minLength
						&& array.get(i).ContainsEmoji() == emoticon)
					arrayfil.add(array.get(i));
		} else if (emoji.equals("notspecified") || emoji.equals("NOTSPECIFIED") || emoji.equals("notSpecified")) {
			// If String is "notSpecified" (and others upper/lower case), by default it
			// takes either
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).LengthMessage() <= maxLength && array.get(i).LengthMessage() >= minLength)
					arrayfil.add(array.get(i));
		} else
			throw new BadStringException();
		return arrayfil;
	}

}
