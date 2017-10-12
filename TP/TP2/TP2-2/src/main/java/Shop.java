package main.java;

/**
 * @author : MESTRALLET Alexis
 * @author : RISCH Philippe
 *
 * Vous trouverez nos méthodes searchDichoEtuRec et searchDichoEtu.
 * Nous avons ajouté une javadoc conformément à notre convention de codage.
 *
 * @version 1.0
 *
 * @author PR
 * Cette classe implemente un shop
 * stock est un tableau d'Articles
 * nbMaxArticle est la taille maximal du stock
 * nbArticle est le nombre d'Article effectivement
 * dans le stock.
 * Le stock est trié par prix croissant puis numéro de nomenclature croissant
 *
 */
public class Shop {
	/**
	 * Le nombre d'article du Magasin
	 */
	private int nbArticle;
	/**
	 * La capacité du magasin
	 */
	private int nbMaxArticle;
	/**
	 * La liste des articles dans le stock du magasin
	 */
	private Article [] stock;
	
	public Shop(int nbart) {
		this.stock = new Article [nbart];
		this.nbArticle = 0;
		this.nbMaxArticle = nbart;
	}
	
	public int getNbArticle() {
		return this.nbArticle;
	}
	public int getNbMaxArticle() {
		return this.nbMaxArticle;
	}
	public Article [] getStock() {
		return this.stock;
	}

	/**
	 * Ajoute un nouveau stock au magasin
	 * @param newStock : le nouveau stock à ajouter au magasin
	 */
	public void setStock( Article [] newStock) {
		int length = newStock.length;
		assert (length <= this.nbMaxArticle); //Brutal
		for (int i =0; i < length; i++) {
			this.stock[i] = newStock[i];
		}
		nbArticle = length;
	}

	/**
	 * recherche dichotomique de l'Article article dans le stock qui
	 * est ordonné de manière croissante
	 * @param article : l'article recherché
	 * @return vrai s'il appartient au stock, faux sinon
	 */
	public Boolean searchDicho1(Article article) {
		int i, j, n, m;
		n = this.nbArticle;
		i = 1;
		j = n;
		m = 0;
		while (i != j) {
			m = (i + j) / 2;
			if (this.stock[m].getPrice() <= article.getPrice())  {
				i = m;
			}
			else {
				j = m;
			}
		}
		return article.getPrice() == this.stock[m].getPrice();		
	}

	/**
	 * version 2 de la recherche
	 * @param article : l'article recherché
	 * @return : vrai s'il appartient au stock, faux sinon
	 */
	public Boolean searchDicho2(Article article) {
		int i, j, n, m;
		n = this.nbArticle;
		boolean found = false;
		i = 1;
		j = n;
		m = 0;
		while (i != j && !found) {
			m = (i + j) / 2;
			if (this.stock[m].getPrice() < article.getPrice())  {
				i = m + 1;
			}
			else {
				if (this.stock[m].getPrice() == article.getPrice()) {
					found = true;
				}
				else {
					j = m - 1;
				}
			}
		}
		return found;		
	}


	/**
	 * version 3 de la recherche
	 * @param article : l'article recherché
	 * @return : vrai s'il appartient au stock, faux sinon
	 */
	public Boolean searchDicho3(Article article) {
		int i, j, n, m;
		n = this.nbArticle;
		boolean found = false;
		i = 0;
		j = n - 1;
		m = 0;
		while (i <= j && !found) {
			m = (i + j) / 2;
			if (this.stock[m].getPrice() == article.getPrice())  {
				found = true;
			}
			else {
				if (this.stock[m].getPrice() < article.getPrice()) {
					j = m - 1;
				}
				else {
					i = m + 1;
				}
			}
		}
		return found;		
	}

	/**
	 * version 4 de la recherche
	 * @param article : l'article recherché
	 * @return : vrai s'il appartient au stock, faux sinon
	 */
	public Boolean searchDicho4(Article article) {
		int i, j, n, m;
		n = this.nbArticle;
		i = 0;
		j = n - 1;
		m = 0;
		while (i <= j) {
			m = (i + j) / 2;
			if (this.stock[m].getPrice() < article.getPrice())  {
				i = m + 1;
			}
			if (this.stock[m].getPrice() > article.getPrice()) {
				j = m - 1;
						}
			if (this.stock[m].getPrice() ==  article.getPrice()) {
				return true;
			}
			if (i > n - 1 || j < 0) {
				return false;
			}
				
		}
		return false;
	}

	/**
	 * version 5 de la recherche
	 * @param article : l'article recherché
	 * @return : vrai s'il appartient au stock, faux sinon
	 */
	public Boolean searchDicho5(Article article) {
		int n = this.nbArticle;
		int i = 0;
		int j = n - 1;
		int m = 0; 
		while (i != j) {
			System.out.println("i : " + i + " j : " + j);
			m = (i + j )/2;
			if (this.stock[m].getPrice() <= article.getPrice()) {
				i = m;
			}
			else {
				j = m;
			}
		}
		return this.stock[m].isEqual(article);
	}

	/**
	 * Version étudiante recursive de la recherche, validé partous les tests
	 * @param article : l'article recherché
	 * @param start : le début du stock (utile pour la récursion)
	 * @param end : la fin du stock (utile pour la récursion)
	 * @return : vrai s'il appartient au stock, faux sinon
	 */
	public boolean searchDichoEtuRec(Article article, int start, int end) {
	    int middle = (start + end)/2 ;
	    if(start < end) {
	        if(stock[middle].isEqual(article)) {
	            return true ;
	        }
	        if (stock[middle].smallerThan(article)) {
	            return searchDichoEtuRec(article, middle + 1, end);
	        }
	        else {
	            return searchDichoEtuRec(article, start, middle - 1);
	        }
	    }
	    else {
	        return false;
	    }
	}

	/**
	 * Version étudiante de la recherche, validé par tous les tests
	 * @param article : l'article recherché
	 * @return : vrai s'il appartient au stock, faux sinon
	 */
	public boolean searchDichoEtu(Article article) {
	    int start = 0 ;
	    int end = nbArticle ;
	    int middle ;
	    while (start < end) {
	        middle = (start + end) / 2;
	        if (this.stock[middle].smallerThan(article))  {
	            start = middle + 1;
	        }
	        else {
	            if (this.stock[middle].isEqual(article)) {
	                return true ;
	            }
	            else {
	                end = middle - 1;
	            }
	        }
	    }
	    return false ;
	}

	/**
	 * Affiche le stock sur la sortie standard
	 */
	public void displayStock() {
		int nbArticle = this.nbArticle;
		System.out.println(this.nbMaxArticle);
		System.out.println(this.nbArticle);
		
		for (int i = 0; i < nbArticle; i++) {
			System.out.println(this.getStock()[i].getNumber() + " + " + this.getStock()[i].getPrice());
		}
	}


	/**
	 * Insère article dans le shop courant dont le stock
	 * est ordonné par prix croissant
	 * @param article : l'article à insérer
	 */
	public void insertArticle(Article article) {
		int i;
		assert (this.getStock().length == this.nbMaxArticle);
		int nbArticle = this.getNbArticle();
//		insertion uniquement si stock non plein
		if (nbArticle < this.nbMaxArticle) {
//			stock vide
			if (nbArticle == 0) {
				this.stock[0] = article;
			}
			else {
//				chercher indice insertion de article
				for (i = 0; i < nbArticle; i++) {
					if (this.stock[i].getPrice() > article.getPrice()) {
						break;
					}
				}
//				insertion en milieu de tableau
				if (i <  nbArticle ) {
//					decaler element un cran a droite
					for (int j = nbArticle; j > i; j--) {
						this.stock[j] = this.stock[j - 1];
					}
//					ajouter article en indice i
					System.out.println("indice insertion");;
					System.out.println(i);
					this.stock[i] = article;
				}
//				prix d'article superieur a tous les autres donc
//				insertion apres dernier element
				else {
					this.stock[nbArticle] = article;
				}	
			}
//			incrementer le nb d'articles present après une insertion
			this.nbArticle ++;
		}
		else {
			System.out.println("capacite atteinte");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("nbarticle = 10");
		Shop shop = new Shop(10);
		@SuppressWarnings("unused")
		String nom;
		double  prix;
		int numero;
		for (int i = 0; i < 10; i++) {
			nom = "";
			prix = 10 - i;
			numero = i;
			Article article = new Article("a", prix, numero);
			shop.insertArticle(article);
		}
		System.out.println(shop.getNbArticle());
		shop.nbArticle = 10;
		System.out.print("done\n");
		shop.displayStock();

	}
}
