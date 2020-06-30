
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

	@Override
	public ArrayListFacebookPost filterByLengthMessage(ArrayListFacebookPost array, Integer value) {
		filteredList = null;
		System.out.println("**\nFILTERED FOR: length message=" + value + "\n");
		for (int i = 0; i < array.getSize(); i++)
			if (((Integer) array.getPost(i).getLengthMessage()).equals(value))
				filteredList.addPost(array.getPost(i));
		return filteredList;
	}

	@Override
	public ArrayListFacebookPost filterByReactions(ArrayListFacebookPost array, Integer value) {
		filteredList = null;
		System.out.println("**\nFILTERED FOR: reactions=" + value + "\n");
		for (int i = 0; i < array.getSize(); i++)
			if (((Integer) array.getPost(i).getReactions()).equals(value))
				filteredList.addPost(array.getPost(i));
		return filteredList;
	}

	@Override
	public ArrayListFacebookPost filterByShares(ArrayListFacebookPost array, Integer value) {
		filteredList = null;
		System.out.println("**\nFILTERED FOR: shares=" + value + "\n");
		for (int i = 0; i < array.getSize(); i++)
			if (((Integer) array.getPost(i).getShares()).equals(value))
				filteredList.addPost(array.getPost(i));
		return filteredList;
	}

}
