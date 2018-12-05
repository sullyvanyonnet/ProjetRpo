package Etape;

import Fourmi.Fourmi;

public class Nymphe extends Phase {
	
	static double dureeNymphe = 16;
	
	public Nymphe(Fourmi fourmi) {
		super(fourmi);
		fourmi.setDureeDeVie(dureeNymphe);
	}
	
	@Override
	public String jeSuis() {
		  return "nymphe";
	  }
	
	//TODO faire comme dans oeuf
	public Phase phaseSuivante() {
		if (this.fourmi.getDureeDeVie() > dureeNymphe) return this;
		return new Adulte(fourmi);
	}
}