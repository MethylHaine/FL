package essai;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Alexis MESTRALLET
 * @author Philippe RISCH
 *
 */
public class EssaiTest {
	
	private Essai essai1;
	private Essai essai2;

	@Before
	public void setUp() throws Exception {		
		essai1 = new Essai(new Random().nextDouble());
		essai2 = new Essai(new Random().nextDouble());
		System.out.println("Appel de setUp() - @Before");
	}
	
	@After
	public void tearDown() {
		System.out.println("Appel de tearDown() - @After");
	}
	
	@BeforeClass
	static public void setUpBeforeClass() throws Exception {
		System.out.println("Appel de setUpBeforeClass() - @BeforeClass");
	}
	
	@AfterClass
	static public void tearDownAfterClass() {
		System.out.println("Appel de tearDownAfterClass() - @AfterClass");
	}

	@Test
	public void testGetVal() {
		assertNotNull("Valeur de retour essai1 nulle", essai1.getVal());
		assertNotNull("Valeur de retour essai2 nulle", essai2.getVal());		
	}

	@Test
	public void testSetVal() {
		int random1 = new Random().nextInt();
		int random2 = new Random().nextInt();
		
		essai1.setVal(random1);
		essai2.setVal(random2);
		
		Essai essaiFaux = new Essai(new Random().nextDouble());
		essaiFaux.setVal(4);
		assertNotEquals("essaiFaux.SetVal ne fixe pas la valeur attendue", (int) essaiFaux.getVal(), 5);
		
		assertEquals("essai1.SetVal ne fixe pas la valeur attendue", essai1.getVal(), random1, 0.00);
		assertEquals("essai2.SetVal ne fixe pas la valeur attendue", essai2.getVal(), random2, 0.00);
		
	}

	@Test
	public void testEssai() {
		assertNotNull("essai1 nul", essai1);
		assertNotNull("essai2 nul", essai2);
		testGetVal();
	}
	
	/**
	 * Test de la levée d'exception qui empêche la division par 0.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testInverserValException() {
		essai1.setVal(0);
		essai1.inverserVal();
	}
	
	@Test
	public void testInverserVal() {
		double val = essai1.getVal() ;
		if(val == 0.0) {
			testInverserValException();
		}
		else {
			assertEquals("L'inverse n'est pas celui attendu", essai1.inverserVal(), 1/val, 0.0);
		}
	}

}
