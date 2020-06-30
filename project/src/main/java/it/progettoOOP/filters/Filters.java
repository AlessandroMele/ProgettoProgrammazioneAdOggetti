
/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.filters;

import it.progettoOOP.model.ArrayListFacebookPost;

public class Filters implements FiltersMethods {
	private ArrayListFacebookPost filteredList;

	public Filters() {
		filteredList = new ArrayListFacebookPost();
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the ArrayList that contain's filter's reactions requirement
	 *         ArrayListFacebookPost
	 */
	@Override
	public ArrayListFacebookPost filterByLengthMessage(ArrayListFacebookPost array, int min, int max) {
		filteredList = null;
		try {
			System.out.println("**FILTERED FOR: length message: min=" + min + " max=" + max + "\n");
			for (int i = 0; i < array.getSize(); i++)
				if (array.getPost(i).getLengthMessage() > min && array.getPost(i).getLengthMessage() < max)
					filteredList.addPost(array.getPost(i));
		} catch (NullPointerException e) {// e.printStackTrace();
			System.out.println("No contents");
		}
		return filteredList;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the ArrayList that contain's filter's reactions requirement
	 *         ArrayListFacebookPost
	 */
	@Override
	public ArrayListFacebookPost filterByReactions(ArrayListFacebookPost array, int min, int max) {
		filteredList = null;
		try {
			System.out.println("**FILTERED FOR: reactions: min=" + min + " max=" + max + "\n");
			for (int i = 0; i < array.getSize(); i++)
				if (array.getPost(i).getLengthMessage() > min && array.getPost(i).getLengthMessage() < max)
					filteredList.addPost(array.getPost(i));
		} catch (NullPointerException e) {// e.printStackTrace();
			System.out.println("No contents");
		}
		return filteredList;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the ArrayList that contain's filter's reactions requirement
	 *         ArrayListFacebookPost
	 */
	@Override
	public ArrayListFacebookPost filterByShares(ArrayListFacebookPost array, int min, int max) {
		filteredList = null;
		try {
			System.out.println("**FILTERED FOR: shares: min=" + min + " max=" + max + "\n");
			for (int i = 0; i < array.getSize(); i++)
				if (array.getPost(i).getLengthMessage() > min && array.getPost(i).getLengthMessage() < max)
					filteredList.addPost(array.getPost(i));
		} catch (NullPointerException e) {
			// e.printStackTrace();
			System.out.println("No contents");

		}
		return filteredList;
	}

}
