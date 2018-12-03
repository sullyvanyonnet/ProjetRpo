package Fourmi;

import java.util.concurrent.TimeUnit;

import Etape.Adulte;
import Etape.Cadavre;
import Etape.Etape;
import Etape.Larve;
import Etape.Nymphe;
import Etape.Oeuf;
import Etape.Phase;

public class Fourmi {
	
	private static int PoidsEnMilligramme = 15;
	
	private int identifiant;
	private Double dureeDeVie;  //jours
    private int poids;    
    private Phase phase ;
	
	public Fourmi(int identifiant) {
		this.identifiant = identifiant;
		this.dureeDeVie = (double) 3;
		this.phase = new Oeuf();
	}
	
	public Double getDureeDeVie() {
		return dureeDeVie;
	}
	public void setDureeDeVie(double d) {
		this.dureeDeVie = d;
	}
	public int getPoids() {
		return poids;
	}
	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}
	
	//TODO methode pour surveiller si la duree de vie de la fourmi n'est pas à 0
	//observer observable du temps
	public void vivre() throws InterruptedException
	{
		
		this.setDureeDeVie(this.getDureeDeVie()-1);
		if(this.getDureeDeVie() == 0)
		{
			this.evolution();
		}
			
		
	}
	
	//evolution
	public void evolution()
	{
		//switch case sur la phase
		switch(this.getPhase().getEtape())
		{
			case oeuf :
				System.out.println("Larve ?");
				this.evolutionLarve();
				break;
			case larve :
				System.out.println("Nymphe ?");
				this.evolutionNymphe();
				break;
			case nymphe :
				System.out.println("Adulte ?");
				this.evolutionAdulte();	
				break;
			case adulte :
				System.out.println("Mourrir ?");
				this.mourrir();
				break;
			default:
				break;			
		}
	}
	
	public void evolutionLarve()
	{
		this.setDureeDeVie(10);
		this.setPhase(new Larve());		
	}
	
	public void evolutionNymphe()
	{
		this.setDureeDeVie(16);
		this.setPhase(new Nymphe());	
	}
	public void evolutionAdulte()
	{
		this.setDureeDeVie(this.dureeVieFourmiAdulte());
		this.setPhase(new Adulte());	
		this.poids = PoidsEnMilligramme;
	}
	
	public double dureeVieFourmiAdulte()
	{
		return (1.5*(1+((7*Math.random())/10)))*365;
	}
	
	public void mourrir()
	{
		this.setDureeDeVie(1);
		this.setPhase(new Cadavre());
	}
}
