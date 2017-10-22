package devise;

/** 
 * @author PR
 * minimalist class for giving example of using jmockit in the tests
 * */
public class DeviseCalculator {

	private TauxChange tauxchange;
	
	public DeviseCalculator(TauxChange tauxchange) {
		this.tauxchange = tauxchange;	
	}
	
	public double euro2euro(double val) {
		return val;
	}
	
	/*renvoie en dollards la valeur de val euros */
	public double euro2dollard(double val) {
		double rate = this.tauxchange.getTaux(val, "euro", "dollard");
		return val * rate;
	}

}
