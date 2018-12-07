package proie;

import modele.Terrain;

public class Araignee extends Proie {
	
	private static int PoidsEnMilligrammeAraignee = 50;
	
	//TODO ajouter parametres en rapport avec la chasse
		//nbDeFourmiAttaquantes
		//nbDeFourmiAttaquantesMax
		//boolean mort
	
	//contructeur d'insecte avec 3 parametre
	public Araignee(int identifiant, int poids, Terrain leTerrain) {
		super(identifiant, poids, leTerrain);
	}
	
	//constructeur insecte avec 2 parametre et un poid par defaut	
	public Araignee(int identifiant,Terrain terrainLie) {
		super(identifiant, terrainLie);
	}

}
