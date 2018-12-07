package proie;

import modele.Terrain;

public class Insecte extends Proie {
	
	private static int PoidsEnMilligrammeInsecte = 30;
	
	//TODO ajouter parametres en rapport avec la chasse
		//nbDeFourmiAttaquantes
		//nbDeFourmiAttaquantesMax
		//boolean mort

	public Insecte(int identifiant, int poids,Terrain terrainLie) {
		super(identifiant, poids, terrainLie);
		// TODO Auto-generated constructor stub
	}
	
	public Insecte(int identifiant, Terrain terrainLie) {
		super(identifiant, PoidsEnMilligrammeInsecte, terrainLie);
	}

}
