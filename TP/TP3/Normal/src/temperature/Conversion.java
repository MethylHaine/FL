package temperature;

/**
 * Classe de conversion de température Farenheit en Celsius et réciproquement.
 * 
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 * 
 * @date 16/10/17
 * 
 * @version 1.0
 */
public class Conversion {

		/**
		 * Méthode de conversion de Farenheit en Celsius
		 * 
		 * @param tempF : La température en Farenheit
		 * @return : La température en Celsius
		 */
		public double convF2C(double tempF) {
			return ((tempF - 32) * 5) / 9.0;
		}
		
		/**
		 * Méthode de conversion de Celsius en Farenheit
		 * 
		 * @param tempC : La température en Celsius
		 * @return : La température en Farenheit
		 */
		public double convC2F(double tempC) {
			return (tempC * 9) / 5.0 + 32;
		}
}
