package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import main.java.Article;
import main.java.Shop;

public class SearchDicho1Test {
	
	
	private Article articleValid;
	private Article articleValid2;
	private Article articleValid3;
	private Article articleToFind;
	private Article articleToFindFalse;
	private Shop shop;
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(10);

	@Before
	public void setUp() throws Exception {
		articleValid = new Article("Article1", 50, 1);
		articleValid2 = new Article("Article2", 51, 2);
		articleValid3 = new Article("Article3", 52, 3);
		articleToFind = new Article("Article3", 52, 3);
		articleToFindFalse = new Article("ToFindFalse", 51.5, 5);
		shop = new Shop(3);
		shop.insertArticle(articleValid);
		shop.insertArticle(articleValid2);
		shop.insertArticle(articleValid3);
		
		//System.out.println("Appel de setUp() - @Before");
	}
	
	@Test
	public void searchDicho1ElementInStock() throws InterruptedException {
		Thread notCurrentThread = new Thread() {
			@Override
			public void run() {
				assertTrue(shop.searchDicho1(articleToFind));
			}
		};

		notCurrentThread.start();

		//Let the current thread sleep (not the created thread!)
		Thread.sleep(5000);
		System.err.println("Test : " + Thread.currentThread().getName() + " => Boucle Infinie ! ");
		System.err.println("Valeur à trouver : " + articleToFind.getPrice() + " présente dans stock");
		System.err.println("Le thread est toujours en vie ? " + Thread.currentThread().isAlive());
		System.err.println("Arrêt du test");
		assertTrue(notCurrentThread.isAlive());
	}

	@Test
	public void searchDicho1ElementNotInStock() throws InterruptedException {
		Thread notCurrentThread = new Thread() {
			@Override
			public void run() {
				assertFalse(shop.searchDicho1(articleToFindFalse));
			}
		};

		notCurrentThread.start();

		//Let the current thread sleep (not the created thread!)
		Thread.sleep(5000);
		System.err.println("Test : " + Thread.currentThread().getName() + " => Boucle Infinie ! ");
		System.err.println("Valeur à trouver : " + articleToFindFalse.getPrice() + " pas présente dans stock");
		System.err.println("Le thread est toujours en vie ? " + Thread.currentThread().isAlive());
		System.err.println("Arrêt du test");
		assertTrue(notCurrentThread.isAlive());
	}
}
