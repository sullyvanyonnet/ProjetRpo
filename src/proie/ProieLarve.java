package proie;

import modele.Terrain;

public class ProieLarve extends Proie {
	
	private static int PoidsEnMilligrammeLarve = 60;
	
	//TODO ajouter parametres en rapport avec la chasse
		//nbDeFourmiAttaquantes
		//nbDeFourmiAttaquantesMax
		//boolean mort
	
	//contructeur Larve avec 3 parametre
	public ProieLarve(int identifiant, Terrain terrainLie) {
		super(identifiant, PoidsEnMilligrammeLarve, terrainLie);
	}
	
	//constructeur insecte avec 2 parametre et un poid par defaut	
	public ProieLarve(int identifiant, int poids, Terrain terrainLie) {
		super(identifiant, poids, terrainLie);
	}

}
