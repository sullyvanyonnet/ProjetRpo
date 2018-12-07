package proie;

import modele.Terrain;

public class ProieLarve extends Proie {
	
	private static int PoidsEnMilligrammeLarve = 60;
	
	//TODO ajouter parametres en rapport avec la chasse
		//nbDeFourmiAttaquantes
		//nbDeFourmiAttaquantesMax
		//boolean mort

	public ProieLarve(int identifiant, Terrain terrainLie) {
		super(identifiant, PoidsEnMilligrammeLarve, terrainLie);
	}
	
	public ProieLarve(int identifiant, int poids, Terrain terrainLie) {
		super(identifiant, poids, terrainLie);
	}

}
