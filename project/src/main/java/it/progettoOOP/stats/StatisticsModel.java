/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */
package it.progettoOOP.stats;

import java.util.ArrayList;

import it.progettoOOP.stats.StatisticsMethods;

/**
 * It contains minimum attributes about statistics values and implementations
 * about StatisticsMethods' methods
 */
public class StatisticsModel implements StatisticsMethods {
	/**
	 * Average value contained on a generic field
	 */
	private double average;
	/**
	 * Sum value contained on a generic field
	 */
	private int sum;
	/**
	 * Maximum value contained on a generic field
	 */
	private int max;
	/**
	 * Minimum value contained on a generic field
	 */
	private int min;
	/**
	 * Perch of a generic field of a filtered array compared to complete array
	 */
	private double perch;

	/**
	 * Total value contained on a generic field
	 */
	private int total;

	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * @return the sum
	 */
	public int getSum() {
		return sum;
	}

	/**
	 * @return the maximum
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @return the minimum
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @return the perch
	 */
	public double getPerch() {
		return perch;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Basic constructor
	 */
	public StatisticsModel() {
		average = 0.0;
		sum = 0;
		max = 0;
		min = 0;
		perch = 0.0;
		total = 0;
	}

	/**
	 * Constructor for StatisticsModel using filtered and complete
	 * ArrayList<Integer>
	 */
	public StatisticsModel(ArrayList<Integer> arrayfill, ArrayList<Integer> arrayfull) {
		min = MinValue(arrayfill);
		max = MaxValue(arrayfill);
		average = AverageValue(arrayfill);
		sum = SumValue(arrayfill);
		perch = PerchValue(arrayfill, arrayfull);
		total = TotalValue(arrayfull);
	}

	/**
	 * It calculates the total of a field contained on filtered ArrayList<Integer>
	 * 
	 * @param array the ArrayList<Integer> for calculating total
	 * @return total value of a field contained in ArrayList<Integer>
	 */
	public int TotalValue(ArrayList<Integer> array) {
		total = 0;
		for (int i = 0; i < array.size(); i++)
			total = total + array.get(i);
		return total;
	}

	/**
	 * It calculates the perch of a field contained on filtered ArrayList<Integer>
	 * compared to the full ArrayList<Integer>
	 * 
	 * @param array     the ArrayList<Integer> filtered for calculating perch
	 * @param arrayfull the complete ArrayList<Integer> for calculating perch
	 * @return total value of a field contained in first ArrayList<Integer> compared
	 *         to the second ArrayList<Integer>
	 */
	public double PerchValue(ArrayList<Integer> array, ArrayList<Integer> arrayfull) {
		perch = 0.0;
		try {
			perch = (double) (TotalValue(array) * 100) / TotalValue(arrayfull);
		} catch (ArithmeticException e) {
		}
		return Math.floor(perch * 100.0) / 100.0;
	}

	/**
	 * It calculates the sum of a field contained on filtered ArrayList<Integer>
	 * 
	 * @param array the ArrayList<Integer> for calculating sum
	 * @return sum value of a field contained in ArrayList<Integer>
	 */
	@Override
	public int SumValue(ArrayList<Integer> array) {
		sum = 0;
		for (int i = 0; i < array.size(); i++)
			sum += array.get(i);
		return sum;
	}

	/**
	 * It calculates the average of a field contained on filtered ArrayList<Integer>
	 * 
	 * @param array the ArrayList<Integer> for calculating average
	 * @return average value of a field contained in ArrayList<Integer>
	 */
	@Override
	public double AverageValue(ArrayList<Integer> array) {
		average = 0.0;
		try {
			average = (double) SumValue(array) / array.size();
		} catch (ArithmeticException e) {
		}
		return Math.floor(average * 100.0) / 100.0;
	}

	/**
	 * It calculates the maximum of a field contained on filtered ArrayList<Integer>
	 * 
	 * @param array the ArrayList<Integer> for calculating maximum
	 * @return maximum value of a field contained in ArrayList<Integer>
	 */
	@Override
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
	 * It calculates the minimum of a field contained on filtered ArrayList<Integer>
	 * 
	 * @param array the ArrayList<Integer> for calculating minimum
	 * @return minimum value of a field contained in ArrayList<Integer>
	 */
	@Override
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
