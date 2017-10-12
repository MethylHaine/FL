package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import main.java.Article;
import main.java.Magasin;

public class ChercherDichoEtuTest {
	
	private Article articleValid;
	private Article articleValid2;
	private Article articleValid3;
	private Magasin magasin;
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	@Before
	public void setUp() throws Exception {
		articleValid = new Article("Article1", 50, 1);
		articleValid2 = new Article("Article2", 51, 2);
		articleValid3 = new Article("Article3", 52, 3);
		magasin = new Magasin(10);
		magasin.insererArticle(articleValid);
		magasin.insererArticle(articleValid2);
		magasin.insererArticle(articleValid3);
	}

	@Test
	public void chercherDichoEtuElementInTableTest() {
		Article articleToFind = new Article("Article3", 52, 3);
		assertTrue(magasin.chercherDichoEtu(articleToFind));
		assertTrue(articleValid3.isEqual(articleToFind));
	}
	
	@Test
	public void chercherDichoEtuElementNotInTableTest() {
		Article articleToFindFalse = new Article("ToFindFalse", 51.5, 5);
		assertFalse(magasin.chercherDichoEtu(articleToFindFalse));
		assertFalse(articleValid3.isEqual(articleToFindFalse));
	}

	@Test
	public void chercherDichoEtuElementWrongNameTest() {
		Article articleToFindWrongName = new Article("WrongName", 52, 3);
		assertFalse(magasin.chercherDichoEtu(articleToFindWrongName));
		assertFalse(articleValid3.isEqual(articleToFindWrongName));	
	}
	
	@Test
	public void chercherDichoEtuElementWrongNumber() {
		Article articleToFindWrongNumber = new Article("Article3", 52, 5);
		assertFalse(magasin.chercherDichoEtu(articleToFindWrongNumber));
		assertFalse(articleValid3.isEqual(articleToFindWrongNumber));
	}
	
	@Test
	public void chercherDichoEtuElementWrongPrice() {
		Article articleToFindWrongPrice = new Article("Article3", 52.01, 3);
		assertFalse(magasin.chercherDichoEtu(articleToFindWrongPrice));
		assertFalse(articleValid3.isEqual(articleToFindWrongPrice));
	}
	
	@Test
	public void chercherDichoElementMini() {
		Article articleFree = new Article("Article3", 0.00, 3);
		assertFalse(magasin.chercherDichoEtu(articleFree)) ;
		magasin.insererArticle(articleFree);
		assertTrue(magasin.chercherDichoEtu(articleFree)) ;
	}
	
	@Test
	public void chercherDichoElementMax() {
		Article articleExpensive = new Article("Article3", 10000.01, 3);
		assertFalse(magasin.chercherDichoEtu(articleExpensive)) ;
		magasin.insererArticle(articleExpensive);
		assertTrue(magasin.chercherDichoEtu(articleExpensive)) ;
	}
}
