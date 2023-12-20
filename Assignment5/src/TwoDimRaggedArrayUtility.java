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

import java.io.*;
import java.util.Scanner;

/**
 * @author Huan Shiuan Huang
 */
public class TwoDimRaggedArrayUtility {

	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data - the two dimensional array getting the average of
	 * @return the average of the elements in the two dimensional array (total of elements/num of elements)
	 */
	public static double getAverage(double[][] data) {
		double total = 0;
		int num = 0;
		//Find the total of this array
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				num++;
				total += data[i][j];
			}
		}
		return total / num;
	}

	/**
	 * Returns the total of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		//Find the total in this column
		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) 
		        continue;
			total += data[i][col];
		}
		return total;
	}

	/**
	 * Returns the largest element in the two dimensional array
	 * @param data - the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double large = data[0][0];
		//Find the highest element in array
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (large < data[i][j])
					large = data[i][j];
			}
		}
		return large;
	}

	/**
	 * Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to find the largest element of (0 refers to the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double large = -999999999;
		//Find the highest element in this column
		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) 
		        continue;
			if (large < data[i][col])
				large = data[i][col];
		}
		return large;
	}

	/**
	 * Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to find the largest element of (0 refers to the first column)
	 * @return the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double large = -9999999;
		int index = 0;
		//Find the highest element index in column
		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length) 
		        continue;
			if (large < data[i][col]) {
				large = data[i][col];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double large = -999999999;
		//Find the highest element in row
		for (int i = 0; i < data[row].length; i++) {
			if (large < data[row][i])
				large = data[row][i];
		}
		return large;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double large = -999999999;
		int index = 0;
		//Find the highest element index in row
		for (int i = 0; i < data[row].length; i++) {
			if (large < data[row][i]) {
				large = data[row][i];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data - the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double smallest = data[0][0];
		//Find the lowest element in array
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (smallest > data[i][j])
					smallest = data[i][j];
			}
		}
		return smallest;
	}

	/**
	 * Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to find the smallest element of (0 refers to the first column)
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double small = 999999999;
		//Find the lowest element in column
		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length)
		        continue;
			if (small > data[i][col])
				small = data[i][col];
		}
		return small;
	}

	/**
	 * Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data - the two dimensional array
	 * @param col - the column index to find the smallest element of (0 refers to the first column)
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double small = 999999999;
		int index = 0;
		//Find the lowest element in array
		for (int i = 0; i < data.length; i++) {
			if (col >= data[i].length)
		        continue;
			if (small > data[i][col]) {
				small = data[i][col];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to find the smallest element of (0 refers to the first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double small = 999999999;
		//Find the lowest element in row
		for (int i = 0; i < data[row].length; i++) {
			if (small > data[row][i])
				small = data[row][i];
		}
		return small;
	}

	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to find the smallest element of (0 refers to the first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double small = 999999999;
		int index = 0;
		//Find the lowest element index in row
		for (int i = 0; i < data[row].length; i++) {
			if (small > data[row][i]) {
				small = data[row][i];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data - the two dimensional array
	 * @param row - the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		//calculate the total element in row
		for (int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		return total;
	}

	/**
	 * Returns the total of all the elements of the two dimensional array
	 * @param data - the two dimensional array
	 * @return the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		double total = 0;
		//calculate the total element in array
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++)
				total += data[i][j];
		}
		return total;
	}

	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum columns for 
	 * each row is 10 Each row in the file is separated by a new line Each element in the row is separated by a 
	 * space Suggestion: You need to know how many rows and how many columns there are for each row to create a 
	 * ragged array. 1. Read the doubles from the file into an a temporary array [10][10] of Strings which was 
	 * initialized to nulls. 2. Find out how many rows there are (any row that has the first element != null is 
	 * a valid row) 3. Create the array based on the num of rows, i.e. double[][]array = new double[#rows][] 
	 * 4. Determine the number of columns for the first row (any element != null is a valid element) 5. Create 
	 * the first row, i.e. array[0] = new double[#columns] 6. Put the values from the temporary array into in the 
	 * row (don't forget to convert from strings to doubles) 7. Repeat for all rows
	 * @param file - the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty, returns 
	 * a null if file is empty
	 * @throws java.io.FileNotFoundException
	 */
	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException {
		Scanner sc = new Scanner(file);
		final int MAX_ROW_COL = 10;
		int row = 0; 
		String[][] str = new String[MAX_ROW_COL][];
		
		//Read the number in the file to the String array, and find out the row it has
		for(int i = 0; sc.hasNextLine(); i++) {
			str[i]  = sc.nextLine().split(" ");
			row++;
		}
		
		double[][] data = new double[row][];
		
		//Copy the String array to the double array
		for(int i = 0; i < row; i++) {
			data[i] = new double[str[i].length];
			for(int j = 0; j< str[i].length; j++) {
				data[i][j] = Double.parseDouble(str[i][j]);
			}
		}
		
		sc.close();
		return data;
	}

	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate line within the file and 
	 * each double is separated by a space.
	 * @param data - two dimensional ragged array of doubles
	 * @param outputFile - the file to write to
	 * @throws java.io.FileNotFoundException - if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException {
		PrintWriter out = new PrintWriter(outputFile);
		
		//Print the double array into the file
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				out.print(data[i][j] + " ");
			}
			out.println();
		}
		out.close();
	}
}