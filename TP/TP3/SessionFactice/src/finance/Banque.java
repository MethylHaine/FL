package finance;

public class Banque {
	
	public Banque() {
	}

	public Boolean authentifier(long numeroCarte, int codeSecurite) {
		return true;
	}
	
	public Boolean autoriser(int numeroSession, String operation) {
		return true;
	}
}
