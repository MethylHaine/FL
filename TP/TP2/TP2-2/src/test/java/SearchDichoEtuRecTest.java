package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import main.java.Article;
import main.java.Shop;

public class SearchDichoEtuRecTest {
	
	private Article articleValid;
	private Article articleValid2;
	private Article articleValid3;
	private Shop shop;
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	@Before
	public void setUp() throws Exception {
		articleValid = new Article("Article1", 50, 1);
		articleValid2 = new Article("Article2", 51, 2);
		articleValid3 = new Article("Article3", 52, 3);
		shop = new Shop(10);
		shop.insertArticle(articleValid);
		shop.insertArticle(articleValid2);
		shop.insertArticle(articleValid3);
	}

	@Test
	public void searchDichoEtuRecElementInTableTest() {
		Article articleToFind = new Article("Article3", 52, 3);
		assertTrue(shop.searchDichoEtuRec(articleToFind, 0, shop.getNbArticle()));
		assertTrue(articleValid3.isEqual(articleToFind));
	}
	
	@Test
	public void searchDichoEtuRecElementNotInTableTest() {
		Article articleToFindFalse = new Article("ToFindFalse", 51.5, 5);
		assertFalse(shop.searchDichoEtuRec(articleToFindFalse, 0, shop.getNbArticle()));
		assertFalse(articleValid3.isEqual(articleToFindFalse));
	}

	@Test
	public void searchDichoEtuRecElementWrongName() {
		Article articleToFindWrongName = new Article("WrongName", 52, 3);
		assertFalse(shop.searchDichoEtuRec(articleToFindWrongName, 0, shop.getNbArticle()));
		assertFalse(articleValid3.isEqual(articleToFindWrongName));	
	}
	
	@Test
	public void searchDichoEtuRecElementWrongNumber() {
		Article articleToFindWrongNumber = new Article("Article3", 52, 5);
		assertFalse(shop.searchDichoEtuRec(articleToFindWrongNumber, 0, shop.getNbArticle()));
		assertFalse(articleValid3.isEqual(articleToFindWrongNumber));
	}
	
	@Test
	public void searchDichoEtuRecElementWrongPrice() {
		Article articleToFindWrongPrice = new Article("Article3", 52.01, 3);
		assertFalse(shop.searchDichoEtuRec(articleToFindWrongPrice, 0, shop.getNbArticle()));
		assertFalse(articleValid3.isEqual(articleToFindWrongPrice));
	}
	
	@Test
	public void searchDichoElementMini() {
		Article articleFree = new Article("Article3", 0.00, 3);
		assertFalse(shop.searchDichoEtuRec(articleFree, 0, shop.getNbArticle())) ;
		shop.insertArticle(articleFree);
		assertTrue(shop.searchDichoEtuRec(articleFree, 0, shop.getNbArticle())) ;
	}
	
	@Test
	public void searchDichoElementMax() {
		Article articleExpensive = new Article("Article3", 10000.01, 3);
		assertFalse(shop.searchDichoEtuRec(articleExpensive, 0, shop.getNbArticle())) ;
		shop.insertArticle(articleExpensive);
		assertTrue(shop.searchDichoEtuRec(articleExpensive, 0, shop.getNbArticle())) ;
	}
}
