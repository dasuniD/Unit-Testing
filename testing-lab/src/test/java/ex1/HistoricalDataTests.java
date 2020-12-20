package ex1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class HistoricalDataTests {

	@Test
	@DisplayName("Test1 add method")
	void verifyAdd1() {
		HistoricalData HD = new HistoricalData(5.0,2.0,2);
		HD.add(4.0);
		assertEquals(4.0, HD.max(), "after adding 4.0 max should be 4.0");
		HD.add(3.0);
		assertEquals(4.0, HD.max(), "after adding 3.0 max should be 4.0");
	}

	@Test
	@DisplayName("Test2 add method")
	void verifyAdd2() {
		HistoricalData HD = new HistoricalData(5.0,2.0,2);
		HD.add(1.0);
		assertEquals(4.0, HD.max(), "after adding 1.0 max should be 2.0");
	}

	@Test
	@DisplayName("Test average method")
	void verifyZeroException1() {
		HistoricalData HD = new HistoricalData(0.0,0.0,0);
		Exception exception = assertThrows(ArithmeticException.class,()->HD.average());
		assertEquals("divided by zero",exception.getMessage(),"exception should match");
	}

	@Test
	@DisplayName("Test max method")
	void verifyZeroException2() {
		HistoricalData HD = new HistoricalData(0.0,0.0,0);
		Exception exception = assertThrows(ArithmeticException.class,()->HD.max());
		assertEquals("divided by zero",exception.getMessage(),"exception should match");
	}




	
}
