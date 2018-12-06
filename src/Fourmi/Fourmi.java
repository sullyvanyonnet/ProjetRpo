package Fourmi;

import java.awt.Point;

import Etape.Adulte;
import Etape.Cadavre;
import Etape.Larve;
import Etape.Nymphe;
import Etape.Oeuf;
import Etape.Phase;
import Role.Ouvrier;
import modele.EtreVivant;
import modele.InterfaceMorph;

public class Fourmi extends EtreVivant {
	
	private static int PoidsEnMilligramme = 15;
	
	private int identifiant;
	private Double dureeDeVie;  //jours
    private int poids;    
    private Phase phase ;
    
    public Fourmi(int identifiant) {
		this.identifiant = identifiant;
		this.dureeDeVie = (double) 3;
		this.phase = new Oeuf(this);
	}
	
	public Fourmi(int identifiant, Point unPoint) {
		this.identifiant = identifiant;
		this.dureeDeVie = (double) 3;
		this.phase = new Oeuf(this);
		this.representationGraphique = InterfaceMorph.CreeFourmi(unPoint);
	}
	
	public int getIdentifiant() {
		return this.identifiant;
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
	
	//vivre pendant un tick
	//evoluer si la duree d'une phase s'est écoulée
	public void vivre() throws InterruptedException
	{
		
		this.setDureeDeVie(this.getDureeDeVie()-1);
		if(this.getDureeDeVie() == 0)
		{
			this.evolution();
		}		
	}
	
	/*DO fonction retourne une chaine 
	de caracteres pour signaler le type d'objet : 
	oeuf, larve, nymphe */
	public String isPhase()
	{
		return getPhase().jeSuis();
	}
	
	//evolution
	public void evolution()
	{
		phase = phase.phaseSuivante();
	}
	
	public double dureeVieFourmiAdulte()
	{
		return (1.5*(1+((7*Math.random())/10)))*365;
	}
	
	public double dureeVieFourmiReine()
	{
		return (4*(1+((1.5*Math.random())/10)))*365;
	}
	
	public void seDeplacer() {		
		if(this.phase.jeSuis().equals("adulte")) {
			Adulte unAdulte = (Adulte)this.phase;
			this.representationGraphique.setPosition(unAdulte.seDeplacer(this.representationGraphique.getPosition()));
			
		}
	}
	
	
	public boolean devenirReine()
	{		
		boolean res = this.getPhase().devenirReine();
		if(res)
		{
			this.dureeDeVie = this.dureeVieFourmiReine();
		}				
		return res;
	}
	
	public boolean devenirOuvrier()
	{		
		boolean res = this.getPhase().devenirOuvrier();
		return res;
	}	
	
	public boolean devenirSoldat()
	{		
		boolean res = this.getPhase().devenirSoldat();
		return res;
	}	
	
	public boolean devenirReproducteur() {
		boolean res = this.getPhase().devenirReproducteur();
		return res;
	}

	@Override
	public void updateH() {
		Phase unephase = this.getPhase();
		if(unephase.jeSuis().equals("adulte")) {
			this.seDeplacer();
			
			//Adulte unAdulte = (Adulte)unephase;
			//unAdulte.updateH();
		}
	}

	@Override
	public void updateJ() {
		//realise le viellissement
		try {
			this.vivre();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Phase unephase = this.getPhase();
		if(unephase.jeSuis().equals("adulte")) {
			//Adulte unAdulte = (Adulte)unephase;
			//unAdulte.updateJ();
		}
	}
}