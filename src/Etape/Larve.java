package Etape;

import java.util.Random;

import Fourmi.Fourmi;

public class Larve extends Phase {
	
	static double dureeLarve = 10;
	
	public Larve(Fourmi fourmi) {
		//utilise le contructeur de phase
		super(fourmi);
		//defini le temps de vie de la fourmi
		fourmi.setDureeDeVie(dureeLarve);
		//defini le point de la fourmit
		fourmi.setPoids(calculPoids());
	}
	 //retour la phase de la fourmi en chaine de charactere 
	@Override
	public String jeSuis() {
		  return "larve";
	  }
	
	//permet de definire la phase suivante 
	public Phase phaseSuivante() {
		//si la fourmi lui reste du temps dans ca phase retour l'objet courant
		if (this.fourmi.getDureeDeVie() < dureeLarve) return new Nymphe(fourmi);
		//sinon retour la creation de la phase suivante 
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