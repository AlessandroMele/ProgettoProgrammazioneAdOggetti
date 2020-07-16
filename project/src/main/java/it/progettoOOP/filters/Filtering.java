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
	 * It returns the ArrayList that satisfies filter's requirement
	 * @param ArrayList<FacebookPost> the array to filter
	 * @param options                 the body of POST request
	 * @return the array filtered
	 *
	 */
	public static ArrayList<FacebookPost> FilteredPosts(ArrayList<FacebookPost> array, Filters filter) {
		ArrayList<FacebookPost> arrayfil = new ArrayList<FacebookPost>();
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).LengthMessage() >= filter.getLengthValues().getMin()
					&& array.get(i).LengthMessage() <= filter.getLengthValues().getMax()
					&& array.get(i).getNumShares() >= filter.getSharesValues().getMin()
					&& array.get(i).getNumShares() <= filter.getSharesValues().getMax()
					&& array.get(i).getNumReactions() >= filter.getReactionsValues().getMin()
					&& array.get(i).getNumReactions() <= filter.getReactionsValues().getMax())
				arrayfil.add(array.get(i));
		}
		return arrayfil;
	}

	/**
	 * It returns the ArrayList that satisfies param's requirements
	 * @param array      the ArrayList<FacebookPost> to filter
	 * @param minLength  the minimum length message of the post
	 * @param mmaxLength the maximum length message of the post
	 * @param emoji      for checking if a message contains or not emoji
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
		Statistics stats = new Statistics(array);
		int min = 0;
		int max = 0;

		if (minLength.equals(""))
			min = stats.getMinLengthMessage();
		else
			min = Integer.parseInt(minLength);
		if (min < 0)
			throw new BadValueException();

		if (maxLength.equals(""))
			max = stats.getMaxLengthMessage();
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
