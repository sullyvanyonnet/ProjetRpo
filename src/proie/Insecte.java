package proie;

public class Insecte extends Proie {
	
	private static int PoidsEnMilligrammeInsecte = 30;
	
	//TODO ajouter parametres en rapport avec la chasse
		//nbDeFourmiAttaquantes
		//nbDeFourmiAttaquantesMax
		//boolean mort

	public Insecte(int identifiant, int poids) {
		super(identifiant, poids);
		// TODO Auto-generated constructor stub
	}
	
	public Insecte(int identifiant) {
		super(identifiant, PoidsEnMilligrammeInsecte);
	}

}
