package temperature;

/**
 * Classe de service permettant l'utilisation de conversion de température
 * 
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 * 
 * @date 16/10/17
 * 
 * @version 1.0
 */
public class ATester {
	/**
	 * L'outil de conversion des températures
	 */
	private Conversion conversion;

	
	public ATester(Conversion conversion) {
		this.conversion = conversion;
	}	
	
	/**
	 * Convertit une température selon un sens donné,
	 * F2C pour Farenheit to Celsius
	 * C2F pour Celsius to Farenheit
	 * 
	 * @param temperature : La température
	 * @param sens : Le type de conversion (F2C xor C2F)
	 * @return : La valeur de la température après conversion
	 */
	public Double convertit(Double temperature, String sens) {
		if(sens.equals("F2C")) {
			return conversion.convF2C(temperature);
		}
		
		if(sens.equals("C2F")) {
			return conversion.convC2F(temperature);
		}
		
		throw new IllegalArgumentException("F2C ou C2F attendu");
	}
}
