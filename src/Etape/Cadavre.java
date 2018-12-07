package Etape;

import Fourmi.Fourmi;

public class Cadavre extends Phase {
	
	static double dureeMort = -1;

	public Cadavre(Fourmi fourmi) {
		super(fourmi);
	}
	
	public Fourmi getFourmi()
	{
		return super.fourmi;
	}
	
	//retour en chaine de charactere la phase de la fourmi
	@Override
	public String jeSuis() {
		  return "cadavre";
	  }
	
	//retour toujours la mort qui est une phase terminale
	public Phase phaseSuivante() {
		return this;
	}

}