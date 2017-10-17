package temperature;

/**
 * Classe d'implémentation Mock de l'interface de 
 * Conversion de température Farenheit en Celsius et réciproquement.
 * 
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 * 
 * @date 16/10/17
 * 
 * @version 1.0
 */
public class MockConversion implements IConversion {
	
	/**
	 * Implémentation Mock de la 
	 * méthode de conversion de Farenheit en Celsius
	 * 
	 * @param tempF : La température en Farenheit
	 * @return : La température en Celsius
	 */
	public double convF2C(double tempF) {
		return 2.00;
	}
	
	/**
	 * Implémentation Mock de la
	 * méthode de conversion de Celsius en Farenheit
	 * 
	 * @param tempC : La température en Celsius
	 * @return : La température en Farenheit
	 */
	public double convC2F(double tempC) {
		return -2.00;
	}

}
