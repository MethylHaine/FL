package testtemperature;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import temperature.MockConversion;
import temperature.ATester;

/**
 * Classe de test de la classe ATester
 * avec implémentation d'un Mock sans interface
 * 
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 * 
 * @date 16/10/17
 * 
 * @version 1.0
 */
public class ATesterTestManualMock {

	private ATester aTester;

	@Before
	public void setUp() throws Exception {
		aTester = new ATester(new MockConversion());
	}
	
	/**
	 * Vérification de la levée d'exception en cas d'un argument invalide
	 */
	@Test(expected=IllegalArgumentException.class)
	public void convertitRaisesExceptionTest() {
		aTester.convertit(666.0, "FAUX");
	}

	/**
	 * Vérification de la méthode de conversion,
	 * sens F2C 
	 */
	@Test
	public void convertitF2CTest() {
		String f2c = "F2C";
		assertEquals(2.00, aTester.convertit(32.0, f2c), 0);
		assertEquals(2.00, aTester.convertit(212.0, f2c), 0);
		assertEquals(2.00, aTester.convertit(98.6, f2c), 0);
		assertEquals(2.00, aTester.convertit(-40.0, f2c), 0);
		assertEquals(2.00, aTester.convertit(10.4, f2c), 0);
	}
	
	/**
	 * Vérification de la méthode de conversion,
	 * sens C2F
	 */
	@Test
	public void ConvertitC2FTest() {
		String c2f = "C2F";
		assertEquals(-2.00, aTester.convertit(0.0, c2f), 0);
		assertEquals(-2.00, aTester.convertit(100.0, c2f), 0);
		assertEquals(-2.00, aTester.convertit(37.0, c2f), 0);
		assertEquals(-2.00, aTester.convertit(-40.0, c2f), 0);
		assertEquals(-2.00, aTester.convertit(-12.0, c2f), 0.2);	
	}
}
