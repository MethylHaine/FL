package essai;

/**
 * TP1
 * 2.2.1 Prise en main
 * 
 * @author Alexis MESTRALLET
 * @author Philippe RISCH
 *
 */
public class Essai {
	
	private double val;
	
	public Essai(double val) {
		this.val = val;
	}
	
	public void ajouter(double val) {
		this.val += val;
	}

	public double getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
	public double inverserVal() {
		if(val == 0.0) {
			throw new IllegalArgumentException();
		}
		
		return 1/val;
	}
}
