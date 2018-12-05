package Etape;

import Fourmi.Fourmi;

public class Oeuf extends Phase {	
	
	static double dureeOeuf = 3;
	
	public Oeuf(Fourmi fourmi) {
		super(fourmi);
	}
	
	@Override
	public String jeSuis() {
		  return "oeuf";
	  }
	
	public Phase phaseSuivante() {
		if (this.fourmi.getDureeDeVie() < dureeOeuf) return this;
		return new Larve(fourmi);
	}
	
	
}