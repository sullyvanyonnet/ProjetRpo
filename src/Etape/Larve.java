package Etape;

import java.util.Random;

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
	
	//si n'ai pas nourrie pas dans la journée, meurt, cf. gestion du temps
	  public void seNourrir() {
		  //consomme son propre poids dans le stock  
	  }
	@Override
	public int calculPoids()
	{
		Random rand = new Random();
		int booleen = rand.nextInt(2);
		return  ((int) (15*(1+((1/3)*Math.random()))) * (3+(1*booleen)));
	}
}