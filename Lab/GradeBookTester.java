import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	private GradeBook grade1, grade2;
	@BeforeEach
	void setUp() throws Exception {
		grade1 = new GradeBook(5);
		grade2 = new GradeBook(5);
		
		grade1.addScore(1);
		grade1.addScore(2);
		grade2.addScore(3);
		grade2.addScore(4);
	}

	@AfterEach
	void tearDown() throws Exception {
		grade1=null;
		grade2=null;
	}

	@Test
	void testAddScore() {
		
		assertTrue(grade1.toString().equals("1.0 2.0 "));
		assertTrue(grade2.toString().equals("3.0 4.0 "));
		
		assertEquals(2, grade1.getScoreSize());
		assertEquals(2, grade2.getScoreSize());
	}

	@Test
	void testSum() {
		
		assertEquals(3, grade1.sum());
		assertEquals(7, grade2.sum());
	}

	@Test
	void testMinimum() {
		
		assertEquals(1, grade1.minimum());
		assertEquals(3, grade2.minimum());
	}

	@Test
	void testFinalScore() {
		
		assertEquals(2, grade1.finalScore());
		assertEquals(4, grade2.finalScore());
	}

	@Test
	void testGetScoreSize() {

	}

	@Test
	void testToString() {
		
	}

}
