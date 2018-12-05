package Etape;

import Fourmi.Fourmi;

public class Larve extends Phase {
	
	static double dureeLarve = 10;
	
	public Larve(Fourmi fourmi) {
		super(fourmi);
	}
	
	@Override
	public String jeSuis() {
		  return "larve";
	  }
	
	public Phase phaseSuivante() {
		if (this.fourmi.getDureeDeVie() < dureeLarve) return this;
		return new Nymphe(fourmi);
	}
}