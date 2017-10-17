package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.java.Article;
import main.java.Shop;

@RunWith(JUnit4.class)

/**
 * Test unitaire de la méthode de recherche dichotomique de l'article dans un stock donné.
 * Il s'agit de la méthode que nous avons créé et qui passe tout les tests.
 * Les tests pour toutes les recherches dichotomiques sont tous identiques.
 *
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 *
 * @version 1.0
 */
public class SearchDichoEtuTest {
	/**
	 * Un article valide dans le stock
	 */
	private Article articleValid;
	/**
	 * Un article valide dans le stock
	 */
	private Article articleValid2;
	/**
	 * Un article valide dans le stock
	 */
	private Article articleValid3;
	/**
	 * Le magasin
	 */
	private Shop shop;

	/**
	 * Ajout du timer limite de 5 secondes pour chaque test
	 */
	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	/**
	 * Instanciation des articles,
	 * instanciation d'un magasin d'une capacité de 10 articles
	 * ajout des articles dans le magasin
	 */
	@Before
	public void setUp() {
		articleValid = new Article("Article1", 50, 1);
		articleValid2 = new Article("Article2", 51, 2);
		articleValid3 = new Article("Article3", 52, 3);
		shop = new Shop(10);
		shop.insertArticle(articleValid);
		shop.insertArticle(articleValid2);
		shop.insertArticle(articleValid3);
	}

	/**
	 * Test du cas favorable où l'article se trouve dans le stock.
	 * Vérifie également si l'article trouvé est bien identique à celui que l'on cherche.
	 */
	@Test
	public void chercherDichoEtuElementInTableTest() {
		Article articleToFind = new Article("Article3", 52, 3);
		assertTrue(shop.searchDichoEtu(articleToFind));
		assertTrue(articleValid3.isEqual(articleToFind));
	}

	/**
	 * Test du cas défavorable où l'article ne se trouve pas dans le stock.
	 */
	@Test
	public void chercherDichoEtuElementNotInTableTest() {
		Article articleToFindFalse = new Article("ToFindFalse", 51.5, 5);
		assertFalse(shop.searchDichoEtu(articleToFindFalse));
		for(int i = 0; i < shop.getNbArticle(); i++) {
			assertFalse(shop.getStock()[0].isEqual(articleToFindFalse));
		}
	}

	/**
	 * Test du cas défavorable où l'article est le même, excepté le nom
	 */
	@Test
	public void chercherDichoEtuElementWrongNameTest() {
		Article articleToFindWrongName = new Article("WrongName", 52, 3);
		assertFalse(shop.searchDichoEtu(articleToFindWrongName));
		assertFalse(articleValid3.isEqual(articleToFindWrongName));	
	}

	/**
	 * Test du cas défavorable où l'article est le même, excepté le numéro
	 */
	@Test
	public void chercherDichoEtuElementWrongNumber() {
		Article articleToFindWrongNumber = new Article("Article3", 52, 5);
		assertFalse(shop.searchDichoEtu(articleToFindWrongNumber));
		assertFalse(articleValid3.isEqual(articleToFindWrongNumber));
	}

	/**
	 * Test du cas défavorable où l'article est le même, excepté le prix
	 */
	@Test
	public void chercherDichoEtuElementWrongPrice() {
		Article articleToFindWrongPrice = new Article("Article3", 52.01, 10);
		assertFalse(shop.searchDichoEtu(articleToFindWrongPrice));
		assertFalse(articleValid3.isEqual(articleToFindWrongPrice));
	}


	/**
	 * Test du cas où l'article recherché est plus petit que celui en tête de stock,
	 * puis l'ajoute, et s'assure que l'article est trouvé en tête de stock.
	 */
	@Test
	public void chercherDichoElementMini() {
		Article articleFree = new Article("Article3", 0.00, 10);
		assertFalse(shop.searchDichoEtu(articleFree)) ;
		shop.insertArticle(articleFree);
		assertTrue(shop.searchDichoEtu(articleFree)) ;
	}

	/**
	 * Test du cas où l'article recherché est plus grand que celui en queue de stock,
	 * puis l'ajoute, et s'assure que l'article est trouvé en queue de stock.
	 */
	@Test
	public void chercherDichoElementMax() {
		Article articleExpensive = new Article("Article3", 10000.01, 10);
		assertFalse(shop.searchDichoEtu(articleExpensive)) ;
		shop.insertArticle(articleExpensive);
		assertTrue(shop.searchDichoEtu(articleExpensive)) ;
	}
}
