package Etape;

import Fourmi.Fourmi;

public class Larve extends Phase {
	
	static double dureeLarve = 10;
	
	public Larve(Fourmi fourmi) {
		super(fourmi);
		fourmi.setDureeDeVie(dureeLarve);
		fourmi.setPoids(calculPoids());
	}
	
	@Override
	public String jeSuis() {
		  return "larve";
	  }
	
	public Phase phaseSuivante() {
		if (this.fourmi.getDureeDeVie() < dureeLarve) return new Nymphe(fourmi);
		return this;
	}
	
	//si ne se nourri pas dans la journée, meurt, cf. gestion du temps
	  public void seNourrir() {
		  //consomme son propre poids dans le stock
		  //nettoyer 1 ou 2 cadavres    
	  }
	
	public int calculPoids()
	{
		return ((int) (15*(1+((1/3)*Math.random()))))*(3|4);
	}
}