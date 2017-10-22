package finance;

public class Session {
	
	private Banque banque;
	private Carte carte;
	private Distributeur distributeur;
	private Boolean connecte;
	private int numeroSession;
	
	public Session(Banque banque, Carte carte, Distributeur distributeur, int numeroSession) {
		this.banque = banque;
		this.carte = carte;
		this.distributeur = distributeur;
		this.connecte = false;
		this.numeroSession = numeroSession;
	}
	
	public void startSession() {
		if(connecte == false) {
			if(banque.authentifier(carte.getNumero(), carte.getCodeSecurite())) {
				connecte = true;
			}
		}
	}
	
	public void validerOperation(String op) throws IllegalOperationException, IllegalCardUseException {
		int essai = 0;
		while(essai < 4) {
			if(distributeur.sendPin(numeroSession) == carte.getPin()) {
				if (banque.autoriser(numeroSession, op) == false) {
					IllegalOperationException exception = new IllegalOperationException(op);
					throw new IllegalOperationException("Opération Invalide", exception);
				} else {
					return;
				}
			} else {
				essai++;
			}
		}
		throw new IllegalCardUseException("Utilisation erronée de la carte");
	}
		

}
