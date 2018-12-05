package Etape;

import Fourmi.Fourmi;

public class Larve extends Phase {
	
	static double dureeLarve = 10;
	
	public Larve(Fourmi fourmi) {
		super(fourmi);
		fourmi.setDureeDeVie(dureeLarve);
	}
	
	@Override
	public String jeSuis() {
		  return "larve";
	  }
	
	public Phase phaseSuivante() {
		if (this.fourmi.getDureeDeVie() < dureeLarve) return new Nymphe(fourmi);
		return this;
	}
}