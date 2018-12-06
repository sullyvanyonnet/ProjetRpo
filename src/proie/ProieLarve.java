package proie;

public class ProieLarve extends Proie {
	
	private static int PoidsEnMilligrammeLarve = 60;
	
	//TODO ajouter parametres en rapport avec la chasse
		//nbDeFourmiAttaquantes
		//nbDeFourmiAttaquantesMax
		//boolean mort

	public ProieLarve(int identifiant) {
		super(identifiant, PoidsEnMilligrammeLarve);
	}
	
	public ProieLarve(int identifiant, int poids) {
		super(identifiant, poids);
	}

}
