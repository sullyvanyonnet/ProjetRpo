package proie;

import modele.Terrain;

public class Araignee extends Proie {
	
	private static int PoidsEnMilligrammeAraignee = 50;
	
	//TODO ajouter parametres en rapport avec la chasse
		//nbDeFourmiAttaquantes
		//nbDeFourmiAttaquantesMax
		//boolean mort
	
	public Araignee(int identifiant, int poids, Terrain leTerrain) {
		super(identifiant, poids, leTerrain);
	}
	
	public Araignee(int identifiant) {
		super(identifiant);
	}

}
