package testtemperature;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import temperature.Conversion;
import temperature.ATester;

/**
 * Classe de test de la classe ATester,
 * avec Conversion.java existant
 * 
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 * 
 * @date 16/10/17
 * 
 * @version 1.0
 */
public class ATesterTest {

	private ATester aTester;

	@Before
	public void setUp() throws Exception {
		aTester = new ATester(new Conversion());
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
		assertEquals(0, aTester.convertit(32.0, f2c), 0);
		assertEquals(100, aTester.convertit(212.0, f2c), 0);
		assertEquals(37, aTester.convertit(98.6, f2c), 0);
		assertEquals(-40, aTester.convertit(-40.0, f2c), 0);
		assertEquals(-12, aTester.convertit(10.4, f2c), 0);
	}
	
	/**
	 * Vérification de la méthode de conversion,
	 * sens C2F
	 */
	@Test
	public void ConvertitC2FTest() {
		String c2f = "C2F";
		assertEquals(32.0, aTester.convertit(0.0, c2f), 0);
		assertEquals(212.0, aTester.convertit(100.0, c2f), 0);
		assertEquals(98.6, aTester.convertit(37.0, c2f), 0);
		assertEquals(-40, aTester.convertit(-40.0, c2f), 0);
		assertEquals(10.4, aTester.convertit(-12.0, c2f), 0.2);	}
}
