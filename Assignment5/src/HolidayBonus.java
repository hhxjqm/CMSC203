/*
	 * Class: CMSC203 
	 * Program: Assignment 5
	 *  Instructor: Grigoriy A. Grinberg
	 * Description: (Create a utility class that manipulates a two-dimensional ragged array of doubles. 
	 * This utility class will be used to create a Sales Report for Retail District #5. It will accommodate positive and negative numbers. 
	 * Follow the Javadoc provided. Create a utility class that will calculate holiday bonuses given a ragged array of 
	 * doubles which represent the sales for each store in each category. It will also take in bonus amount for the 
	 * store with the highest sales in a category, the bonus amount for the store with the lowest sales in a category and the bonus amount for all other stores.
These utility classes will be used with an existing GUI class to create a sales report and display holiday bonuses.
Testing of these utility classes will be done with the JUnit tests and the GUI class provided for you.)
	 *
	 * Due: 8/16/2020
	 * I pledge that I have completed the programming assignment independently.
	   I have not copied the code from a student or any source.
	   I have not given my code to any student.
	   Print your Name here: Huan Shiuan Huang
*/

/**
 * @author Huan Shiuan Huang
 */

public class HolidayBonus {

	/**
	 * Calculates the holiday bonus for each store
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double[data.length];
		int highest, lowest;
		
		//Find the highest and lowest index then give them bonus
		for(int i = 0; i < data.length; i++) {	
			for(int j = 0; j < data[i].length; j++) {
				highest = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
				lowest = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
				if(data[i][j] <= 0) {
					continue;
				}
				if(i != highest && i != lowest) {
					bonus[i] += other;
				}
				else if(i == highest){
				    bonus[i] += high;
				}
				else {
					bonus[i] += low;
				}
			}
		}
		return bonus;
	}

		  /**
		   * Calculates the total holiday bonuses
		   * @param - the two dimensional array of store sales
		   * @param - bonus for the highest store in a category
		   * @param - bonus for the lowest store in a category
		   * @param - bonus for all other stores in a category
		   * @return the total of all holiday bonuses
		   */
		  public static double calculateTotalHolidayBonus(double[][] data, double high, double low,
		      double other) {
		    double total = 0;
		    double[] arr = calculateHolidayBonus(data, high, low, other);
		    
		    //calculate the total bonus
		    for(double i : arr) {
		    	total += i;
		    }
		    return total;
		}
}
