
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	// STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] data1 = { { 1.1 }, { 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 }, { 8.8, 9.9 } };
	private double[][] data2 = { { 1.1, 2.2, 3.3 }, { 4.4, 5.5, 6.6 }, { 7.7, 8.8, 9.9 } };
	private double[][] data3 = { { 1.0, 2.0, 3.0, 4.0 }, {5.0, 6.0 }, { 7.0, 8.0, 9.0 }, {10.0, 11.0}, {12.0, 13.0, 14.0}};

	private File inputFile, outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		data1 = null;
		data2 = null;
		data3 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method Return the total of all the elements in the two
	 * dimensional array
	 */
	@Test
	public void testGetTotal() {

		assertEquals(49.5, TwoDimRaggedArrayUtility.getTotal(data1), .001);
		assertEquals(49.5, TwoDimRaggedArrayUtility.getTotal(data2), .001);
		assertEquals(105, TwoDimRaggedArrayUtility.getTotal(data3), .001);
	}

	/**
	 * Student Test getAverage method Return the average of all the elements in the
	 * two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(5.5, TwoDimRaggedArrayUtility.getAverage(data1), .001);
		assertEquals(5.5, TwoDimRaggedArrayUtility.getAverage(data2), .001);
		assertEquals(7.5, TwoDimRaggedArrayUtility.getAverage(data3), .001);
	}

	/**
	 * Student Test getRowTotal method Return the total of all the elements of the
	 * row. Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(29.7, TwoDimRaggedArrayUtility.getRowTotal(data1, 1), .001);
		assertEquals(16.5, TwoDimRaggedArrayUtility.getRowTotal(data2, 1), .001);
		assertEquals(11.0, TwoDimRaggedArrayUtility.getRowTotal(data3, 1), .001);
	}

	/**
	 * Student Test getColumnTotal method Return the total of all the elements in
	 * the column. If a row in the two dimensional array doesn't have this column
	 * index, it is not an error, it doesn't participate in this method. Column 0
	 * refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(12.1, TwoDimRaggedArrayUtility.getColumnTotal(data1, 0), .001);
		assertEquals(13.2, TwoDimRaggedArrayUtility.getColumnTotal(data2, 0), .001);
		assertEquals(35.0, TwoDimRaggedArrayUtility.getColumnTotal(data3, 0), .001);
	}

	/**
	 * Student Test getHighestInArray method Return the largest of all the elements
	 * in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(9.9, TwoDimRaggedArrayUtility.getHighestInArray(data1), .001);
		assertEquals(9.9, TwoDimRaggedArrayUtility.getHighestInArray(data2), .001);
		assertEquals(14.0, TwoDimRaggedArrayUtility.getHighestInArray(data3), .001);
	}

	/**
	 * Test the writeToFile method write the array to the outputFile File then read
	 * it back to make sure formatted correctly to read
	 * 
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] arr = { { 1.1 }, { 1.1,1.1,1.1,1.1,1.1,1.1}, { 1.1, 1.1 } };
		try {
			TwoDimRaggedArrayUtility.writeToFile(data1, outputFile);
			arr = TwoDimRaggedArrayUtility.readFile(outputFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		for(int i = 0; i < data1.length; i++) {
			for(int j = 0; j < data1[i].length; j++) {
				assertEquals(data1[i][j], arr[i][j], .001);
			}
		}
		
		double[][] arr2 = { { 1.1, 1.1, 1.1 }, { 1.1, 1.1, 1.1 }, { 1.1, 1.1,1.1 } };
		try {
			TwoDimRaggedArrayUtility.writeToFile(data2, outputFile);
			arr2 = TwoDimRaggedArrayUtility.readFile(outputFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		for(int i = 0; i < data2.length; i++) {
			for(int j = 0; j < data2[i].length; j++) {
				assertEquals(data2[i][j], arr2[i][j], .001);
			}
		}
		
		double[][] arr3 = { { 1.0, 1.0, 1.0, 1.0 }, {1.0, 1.0 }, { 1.0, 1.0, 1.0 }, {1.0, 1.0}, {1.0, 1.0, 1.0}};
		try {
			TwoDimRaggedArrayUtility.writeToFile(data3, outputFile);
			arr3 = TwoDimRaggedArrayUtility.readFile(outputFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		for(int i = 0; i < data3.length; i++) {
			for(int j = 0; j < data3[i].length; j++) {
				assertEquals(data3[i][j], arr3[i][j], .001);
			}
		}
	}

}