package proie;

public class Araignee extends Proie {
	
	private static int PoidsEnMilligrammeAraignee = 50;
	
	//TODO ajouter parametres en rapport avec la chasse
		//nbDeFourmiAttaquantes
		//nbDeFourmiAttaquantesMax
		//boolean mort
	
	public Araignee(int identifiant, int poids) {
		super(identifiant, poids);
	}
	
	public Araignee(int identifiant) {
		super(identifiant, PoidsEnMilligrammeAraignee);
	}

}
