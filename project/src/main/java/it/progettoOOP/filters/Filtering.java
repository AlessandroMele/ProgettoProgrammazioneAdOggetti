/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
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
	 * @param options                 the body of the get request
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
	 * @param minLength  the minimum length of the post
	 * @param mmaxLength the maximum length of the post
	 * @param emoji      for checking if a message must contains or not emojis
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
		int minLength = mystat.MinLengthMessage(array);
		int maxLength = mystat.MaxLengthMessage(array);

		String[] rangeLength = param.split(",");
		try {
			String min = rangeLength[0];
			minLength = Integer.parseInt(min);
			if (minLength < 0)
				throw new BadValueException();
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		try {
			String max = rangeLength[1];
			maxLength = Integer.parseInt(max);
			if (maxLength < 0)
				throw new BadValueException();
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		if (maxLength < minLength)
			throw new BadRangeValueException();

		if (emoji.equals("TRUE") || emoji.equals("true") || emoji.equals("FALSE") || emoji.equals("false")) {
			if (emoji.equals("TRUE") || emoji.equals("true"))
				emoticon = true;
			emoticon = false;
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).LengthMessage() <= maxLength && array.get(i).LengthMessage() >= minLength
						&& array.get(i).ContainsEmoji() == emoticon)
					arrayfil.add(array.get(i));
		} else
			throw new BadStringException();
		return arrayfil;
	}

}
