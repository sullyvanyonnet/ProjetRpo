package Etape;

import Fourmi.Fourmi;

public class Cadavre extends Phase {
	
	static double dureeMort = -1;

	public Cadavre(Fourmi fourmi) {
		super(fourmi);
	}
	
	@Override
	public String jeSuis() {
		  return "cadavre";
	  }
	
	public Phase phaseSuivante() {
		return this;
	}

}