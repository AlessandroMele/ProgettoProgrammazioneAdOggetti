/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */
package it.progettoOOP.filters;

import java.util.ArrayList;

/**
 * It contains minimum attributes and methods for filtering
 */
public class FiltersModel {
	/**
	 * Greatest value contained on a generic field
	 */
	private int max;
	/**
	 * Smallest value contained on a generic field
	 */
	private int min;

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * Basic constructor
	 */
	public FiltersModel() {
		max = 0;
		min = 0;
	}

	/**
	 * Constructor for stats using filterd and complete ArrayList<Integer>
	 */
	public FiltersModel(ArrayList<Integer> array) {
		min = MinValue(array);
		max = MaxValue(array);
	}

	/**
	 * It calculates the max of a field contained on filtered ArrayList<Integer>
	 * 
	 * @param array the ArrayList<Integer>
	 * @return max value of a field contained in first ArrayList<Integer>
	 */
	public int MaxValue(ArrayList<Integer> array) {
		if (!array.isEmpty()) {
			max = array.get(0);
			for (int i = 1; i < array.size(); i++)
				if (array.get(i) > max)
					max = array.get(i);
			return max;
		}
		return 0;
	}

	/**
	 * It calculates the min of a field contained on filtered ArrayList<Integer>
	 * 
	 * @param array the ArrayList<Integer>
	 * @return min value of a field contained in first ArrayList<Integer>
	 */
	public int MinValue(ArrayList<Integer> array) {
		if (!array.isEmpty()) {
			min = array.get(0);
			for (int i = 1; i < array.size(); i++)
				if (array.get(i) < min)
					min = array.get(i);
			return min;
		}
		return 0;
	}
}
