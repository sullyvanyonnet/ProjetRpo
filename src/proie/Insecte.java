package proie;

import modele.Terrain;

public class Insecte extends Proie {
	
	private static int PoidsEnMilligrammeInsecte = 30;
	
	//TODO ajouter parametres en rapport avec la chasse
		//nbDeFourmiAttaquantes
		//nbDeFourmiAttaquantesMax
		//boolean mort
	
	//contructeur d'insecte avec 3 parametre
	public Insecte(int identifiant, int poids,Terrain terrainLie) {
		super(identifiant, poids, terrainLie);
	}
	
	//constructeur insecte avec 2 parametre et un poid par defaut
	public Insecte(int identifiant, Terrain terrainLie) {
		super(identifiant, PoidsEnMilligrammeInsecte, terrainLie);
	}

}
