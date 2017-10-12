package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.Article;

public class ArticleTest {
	
	private Article articleValide;
	private Article articleValide2;
	@SuppressWarnings("unused")
	private Article articleInvalide;

	@Before
	public void setUp() throws Exception {
		articleValide = new Article("Article1", 50, 1);
		articleValide2 = new Article("Article2", 50, 2);
		//System.out.println("Appel de setUp() - @Before");
		
	}

	@Test(expected=AssertionError.class)
	public void ArticleEmptyNameTest() {
		articleInvalide = new Article("", 50.99, 3);
	}
	
	@Test(expected=AssertionError.class)
	public void ArticleNegativePriceTest() {
		articleInvalide = new Article("Article1", -50.99, 3);
	}
	
	@Test(expected=AssertionError.class)
	public void ArticleNegativeNumberTest() {
		articleInvalide = new Article("Article1", 50.99, -3);
	}
	
	@Test(expected=AssertionError.class)
	public void ArticleInvalidTest() {
		articleInvalide = new Article("", -25.99, -3);
	}
	
	@Test
	public void ArticleValideTest() {
		articleInvalide = new Article("Article1", 0.00, 0);
	}

	@Test
	public void testGetNom() {
		assertEquals("Article1", articleValide.getNom());
	}

	@Test
	public void testGetPrix() {
		assertEquals(50, articleValide.getPrix(), 0);
	}

	@Test
	public void testGetNumero() {
		assertEquals(1, articleValide.getNumero(), 0);
	}

	@Test
	public void testIsEqual() {
		assertTrue(articleValide.isEqual(articleValide));
		assertFalse(articleValide.isEqual(articleValide2));
		assertFalse(articleValide.isEqual(new Article("Art", 50, 1)));
		assertFalse(articleValide.isEqual(new Article("Article1", 45, 1)));
		assertFalse(articleValide.isEqual(new Article("Article1", 50, 2)));
	}

	@Test
	public void testSmallerThan() {
		assertTrue(articleValide.smallerThan(articleValide2));
		assertFalse(articleValide2.smallerThan(articleValide));
		assertFalse(articleValide.smallerThan(new Article("Article1", 45, 1)));
		assertFalse(articleValide.smallerThan(new Article("Article1", 45, 2)));
		assertTrue(articleValide.smallerThan(new Article("Article1", 55, 1)));
	}
}
