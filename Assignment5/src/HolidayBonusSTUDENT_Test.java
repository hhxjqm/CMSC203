import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusSTUDENT_Test {

	private double[][] data1 = { { 1.1 }, { 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 }, { 8.8, 9.9 } };
	private double[][] data2 = { { 1.1, 2.2, 3.3 }, { 4.4, 5.5, 6.6 }, { 7.7, 8.8, 9.9 } };
	private double[][] data3 = { { 1.0, 2.0, 3.0, 4.0 }, {5.0, 6.0 }, { 7.0, 8.0, 9.0 }, {10.0, 11.0}, {12.0, 13.0, 14.0}};
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		data1 = null;
		data2 = null;
		data3 = null;
	}

	@Test
	void testcalculateHolidayBonus() {
		// test the first data
		double[] arr1 = HolidayBonus.calculateHolidayBonus(data1, 5000, 1000, 2000);
		assertEquals(1000.00, arr1[0], .001);
		assertEquals(23000.00, arr1[1], .001);
		assertEquals(10000.00, arr1[2], .001);
		
		// test second data
		double[] arr2 = HolidayBonus.calculateHolidayBonus(data2, 5000, 1000, 2000);
		assertEquals(3000.00, arr2[0], .001);
		assertEquals(6000.00, arr2[1], .001);
		assertEquals(15000.00, arr2[2], .001);
		
		// test third data
		double[] arr3 = HolidayBonus.calculateHolidayBonus(data3, 1000, 300, 500);
		assertEquals(1900.00, arr3[0], .001);
		assertEquals(1000.00, arr3[1], .001);
		assertEquals(1500.00, arr3[2], .001);
	}

	void testcalculateTotalHolidayBonus() {
		
		// test first data total bonus
		double total1 = HolidayBonus.calculateTotalHolidayBonus(data2, 5000, 1000, 2000);
		assertEquals(34000.00, total1, .001);
		
		//test second data total bonus
	    double total2 = HolidayBonus.calculateTotalHolidayBonus(data2, 5000, 1000, 2000);
		assertEquals(24000.00, total2, .001);
		
		// test third data total bonus
		double total3 = HolidayBonus.calculateTotalHolidayBonus(data3, 5000, 1000, 2000);
		assertEquals(37000.00, total3, .001);
	}
}
