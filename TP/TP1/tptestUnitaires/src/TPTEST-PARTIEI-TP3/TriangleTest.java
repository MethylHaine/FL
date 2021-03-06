package triangle;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Alexis MESTRALLET
 * @author Philippe RISCH
 *
 * Les séparateurs du fichier csv/txt sont des ';'.
 */
public class TriangleTest {

	private Triangle triangleQuelconque;
	private Triangle triangleIsocele;
	private Triangle triangleEquilateral;
	private Triangle nonTriangle;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		triangleQuelconque = new Triangle(7.10, 5.10, 10.10);
		triangleIsocele = new Triangle(10.10, 10.10, 5.10);
		triangleEquilateral = new Triangle(10.10, 10.10, 10.10);
		nonTriangle = new Triangle(5.10, 8.20, 3.10);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Test de la levée d'exception pour fichier inexistant
	 * @throws IOException
	 */
	@Test(expected=FileNotFoundException.class)
	public void testFileNotFoundExceptionCSV() throws IOException {
		Triangle.readData("src/triangle/inexistence.txt");
	}
	
	/**
	 * Test de la levée d'exception pour fichier de format innatendu
	 * @throws IOException
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentExceptionNotTxtFile() throws IOException {
		Triangle.readData("src/triangle/triangle.csv");
	}
	
	/**
	 * Test de la levée d'exception pour fichier de plus d'une ligne qui contient :
	 * 5;7;10
	 * 5;7;11
	 * @throws IOException
	 */
	@Test(expected=IllegalStateException.class)
	public void testIllegalStateExceptionRowLimit() throws IOException {
		Triangle.readData("src/triangle/triangle1.txt");
		
	}

	/**
	 * Contenu du fichier txt :
	 * -5.10;0.00;10.10
	 * @throws IOException
	 */
	@Test
	public void testReadData() throws IOException {
		double[] tab = Triangle.readData("src/triangle/triangle.txt");
		assertEquals("La valeur 1 du tableau ne correspond pas à la valeur dans le csv", -5.10, tab[0], 0.00);
		assertEquals("La valeur 2 du tableau ne correspond pas à la valeur dans le csv", 0.00, tab[1], 0.00);
		assertEquals("La valeur 3 du tableau ne correspond pas à la valeur dans le csv", 10.10, tab[2], 0.00);
	}

	@Test
	public void testIsTriangle() {
		// Tests sur la longueur des côtés
		assertFalse("Le triangle possède au moins 1 côté négatif", new Triangle(-3.10, -5.10, 18.20).isTriangle());
		assertFalse("Le triangle ne possède que 2 côtés", new Triangle(0.00, 5.00, 5.00).isTriangle());
		assertFalse("Le triangle est un segment", new Triangle(0.00, 0.00, 5.00).isTriangle());
		assertFalse("Le triangle est un point", new Triangle(0.00, 0.00, 0.00).isTriangle());
		
		// Tests sur les inégalités triangulaires
		assertFalse("C > A + B", new Triangle(1.10, 2.10, 10.10).isTriangle());
		assertFalse("B > A + C", new Triangle(1.10, 10.10, 2.10).isTriangle());
		assertFalse("A > B + C", new Triangle(10.10, 2.10, 1.10).isTriangle());
		assertFalse("C = A + B", new Triangle(8.10, 2.10, 10.20).isTriangle());
		assertFalse("B = A + C", new Triangle(2.10, 10.20, 8.10).isTriangle());
		assertFalse("A = B + C", new Triangle(10.20, 2.10, 8.10).isTriangle());
		
		// Cas favorable
		assertTrue("Le triangle equilateral est un triangle", triangleEquilateral.isTriangle());
	}

	@Test
	public void testTypeTriangle() {
		assertEquals("Le triangle n'est pas quelconque", 1, triangleQuelconque.typeTriangle(), 0.00);
		assertEquals("Le triangle n'est pas isocèle", 2, triangleIsocele.typeTriangle(), 0.00);
		assertEquals("Le triangle n'est pas equilateral", 3, triangleEquilateral.typeTriangle(), 0.00);
		assertEquals("Les 3 côtés forment un triangle", -1, nonTriangle.typeTriangle(), 0.00);
	}

}
