package Etape;

import Fourmi.Fourmi;

public class Oeuf extends Phase {	
	
	static double dureeOeuf = 3;
	
	public Oeuf(Fourmi fourmi) {
		//utilise le contructeur de phase
		super(fourmi);
	}
	
	 //retour la phase de la fourmi en chaine de charactere 	
	@Override
	public String jeSuis() {
		  return "oeuf";
	  }

	//permet de definire la phase suivante 
	public Phase phaseSuivante() {
		//si la fourmi lui reste du temps dans ca phase retour l'objet courant
		if (this.fourmi.getDureeDeVie() < dureeOeuf) return new Larve(fourmi);
		//sinon retour la creation de la phase suivante 
		return this;
	}	
}