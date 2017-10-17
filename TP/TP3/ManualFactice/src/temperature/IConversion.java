package temperature;


/**
 * Interface de conversion de température Farenheit en Celsius et réciproquement.
 * 
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 * 
 * @date 16/10/17
 * 
 * @version 1.0
 */
public interface IConversion {

	/**
	 * Méthode de conversion de Farenheit en Celsius
	 * 
	 * @param tempF : La température en Farenheit
	 * @return : La température en Celsius
	 */
	public double convF2C(double tempF);
	
	/**
	 * Méthode de conversion de Celsius en Farenheit
	 * 
	 * @param tempC : La température en Celsius
	 * @return : La température en Farenheit
	 */
	public double convC2F(double tempC);
}
