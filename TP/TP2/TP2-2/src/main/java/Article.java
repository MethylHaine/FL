package main.java;
/**
 * MESTRALLET Alexis
 * RISCH Philippe
 *
 * classe Article utilisée dans Magasin
 * 
 * @author PR
 *
 */
public class Article {
	private String name ;
	private double price;
	private int number;

	public Article(String name, double price, int number) {
		assert ( ! name.isEmpty()  && price >= 0 && number >=0);
		this.name = name;
		this.price = price;
		this.number = number;
	}

	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}

	public double getNumber() {
		return this.number;
	}

	/**
	 * Test d'égalité
	 * @param article l'article à tester
	 * @return vrai si l'article en parametre est identique à l'objet courant
	 */
	public Boolean  isEqual(Article article) {
		return  this.name.equals(article.getName()) &&
				this.price == article.getPrice()    &&
				this.number == article.getNumber();
	}
	
	public Boolean smallerThan(Article article) {
		return this.price < article.getPrice() ||
				(this.price == article.getPrice() && this.number < article.getNumber());
	}

}

