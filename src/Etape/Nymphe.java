package Etape;

import Fourmi.Fourmi;

public class Nymphe extends Phase {
	
	static double dureeNymphe = 16;
	
	public Nymphe(Fourmi fourmi) {
		//utilise le contructeur de phase
		super(fourmi);
		//defini le temps de vie de la fourmi
		fourmi.setDureeDeVie(dureeNymphe);
	}
	 //retour la phase de la fourmi en chaine de charactere 
	@Override
	public String jeSuis() {
		  return "nymphe";
	  }
	
	//permet de definire la phase suivante 
	public Phase phaseSuivante() {
		//si la fourmi lui reste du temps dans ca phase retour l'objet courant
		if (this.fourmi.getDureeDeVie() > dureeNymphe) return this;
		//sinon retour la creation de la phase suivante 
		return new Adulte(fourmi);
	}
}