package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import main.java.Article;
import main.java.Magasin;

public class ChercherDichoEtuRecTest {
	
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
	public void chercherDichoEtuRecElementInTableTest() {
		Article articleToFind = new Article("Article3", 52, 3);
		assertTrue(magasin.chercherDichoEtuRec(articleToFind, 0, magasin.getNbArticle()));
		assertTrue(articleValid3.isEqual(articleToFind));
	}
	
	@Test
	public void chercherDichoEtuRecElementNotInTableTest() {
		Article articleToFindFalse = new Article("ToFindFalse", 51.5, 5);
		assertFalse(magasin.chercherDichoEtuRec(articleToFindFalse, 0, magasin.getNbArticle()));
		assertFalse(articleValid3.isEqual(articleToFindFalse));
	}

	@Test
	public void chercherDichoEtuRecElementWrongName() {
		Article articleToFindWrongName = new Article("WrongName", 52, 3);
		assertFalse(magasin.chercherDichoEtuRec(articleToFindWrongName, 0, magasin.getNbArticle()));
		assertFalse(articleValid3.isEqual(articleToFindWrongName));	
	}
	
	@Test
	public void chercherDichoEtuRecElementWrongNumber() {
		Article articleToFindWrongNumber = new Article("Article3", 52, 5);
		assertFalse(magasin.chercherDichoEtuRec(articleToFindWrongNumber, 0, magasin.getNbArticle()));
		assertFalse(articleValid3.isEqual(articleToFindWrongNumber));
	}
	
	@Test
	public void chercherDichoEtuRecElementWrongPrice() {
		Article articleToFindWrongPrice = new Article("Article3", 52.01, 3);
		assertFalse(magasin.chercherDichoEtuRec(articleToFindWrongPrice, 0, magasin.getNbArticle()));
		assertFalse(articleValid3.isEqual(articleToFindWrongPrice));
	}
	
	@Test
	public void chercherDichoElementMini() {
		Article articleFree = new Article("Article3", 0.00, 3);
		assertFalse(magasin.chercherDichoEtuRec(articleFree, 0, magasin.getNbArticle())) ;
		magasin.insererArticle(articleFree);
		assertTrue(magasin.chercherDichoEtuRec(articleFree, 0, magasin.getNbArticle())) ;
	}
	
	@Test
	public void chercherDichoElementMax() {
		Article articleExpensive = new Article("Article3", 10000.01, 3);
		assertFalse(magasin.chercherDichoEtuRec(articleExpensive, 0, magasin.getNbArticle())) ;
		magasin.insererArticle(articleExpensive);
		assertTrue(magasin.chercherDichoEtuRec(articleExpensive, 0, magasin.getNbArticle())) ;
	}
}
