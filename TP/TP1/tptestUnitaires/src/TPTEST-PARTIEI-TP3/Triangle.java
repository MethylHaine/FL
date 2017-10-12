package triangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * TP1
 * 2.2.2 Suite de tests pour la fonction typeTriangle
 * 
 * @author Alexis MESTRALLET
 * @author Philippe RISCH
 */
public class Triangle {
	
	private double coteA;
	private double coteB;
	private double coteC;
	
	public Triangle(double coteA, double coteB, double coteC) {
		this.coteA = coteA;
		this.coteB = coteB;
		this.coteC = coteC;
	}
	
	/**
	 * Méthode statique de la classe Triangle permettant de lire un fichier txt au format CSV.
	 * 
	 * @param pathFile : Le chemin du fichier à lire
	 * @return : tableau de double contenant les côtés du triangle lu
	 * @throws IllegalArgumentException : Si le fichier passé en argument n'est pas un .txt
	 * @throws IllegalArgumentException : Si le fichier passé en argument contient plus d'une ligne
	 */
	public static double[] readData(String pathFile) throws IOException {
		if(Files.notExists(Paths.get(pathFile))) {
			throw new FileNotFoundException();
		}
		
		File fichier = new File(pathFile);
		
		if(!fichier.getName().endsWith(".txt")) {
			throw new IllegalArgumentException(" ! " + fichier.getName());
		}
		
		String[] csv = null ;
		double[] cotes ;
		InputStream fileInputStream = new FileInputStream(fichier);
		InputStreamReader ipsr = new InputStreamReader(fileInputStream);
		
		BufferedReader br = new BufferedReader(ipsr);
		
		int ligneLimite = 1;
		int nbLigne = 0;
		String ligne;
		while((ligne = br.readLine()) != null) {
			nbLigne ++;
			if(nbLigne > ligneLimite) {
				br.close();
				throw new IllegalStateException("Plus d'une ligne dans le fichier CSV");
			}
			csv = ligne.split(";");
		}
		
		cotes = new double[csv.length];
		for(int i=0; i<csv.length; i++) {
			cotes[i] = Double.valueOf(csv[i]);
		}
		
		br.close();
		return cotes;
	}
	
	/**
	 * Vérifie le théorème de l'inégalité triangulaire pour 3 cotés a, b et c
	 * a + b > c
	 * a + c > b
	 * b + c > a 
	 * @return Vrai si les 3 coté forment un triangle, faux sinon
	 */
	public boolean isTriangle() {
		boolean inegalite = coteA + coteB > coteC && 
				coteA + coteC > coteB &&
				coteB + coteC > coteA ;
	
		boolean positifs = coteA > 0 && coteB > 0 && coteC > 0 ;
		return inegalite && positifs ;
	}
	
	/**
	 * Retourne le type de triangle
	 * 
	 * @return : Retourne -1 si ce n'est pas un triangle, 3 si equilatéral, 2 si isocèle, 1 sinon.
	 */
	public int typeTriangle() {
		if(!isTriangle()) {
			return -1 ;
		}
		
		if(coteA == coteB && coteA == coteC && coteB == coteC) {
			return 3;
		}
		
		if(coteA == coteB || coteB == coteC || coteA == coteC) {
			return 2;
		}
		
		return 1;
	}

	public double getCoteA() {
		return coteA;
	}

	public double getCoteB() {
		return coteB;
	}

	public double getCoteC() {
		return coteC;
	}

}
