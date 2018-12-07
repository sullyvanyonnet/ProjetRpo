package Fourmi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import Etape.Adulte;
import Etape.Cadavre;
import Etape.Larve;
import Etape.Nymphe;
import Etape.Oeuf;
import Etape.Phase;
import Role.Ouvrier;
import modele.ObjetGraphique;
import modele.InterfaceMorph;
import modele.Terrain;
import vue.Morph;
import vue.Oval;

public class Fourmi extends ObjetGraphique {
	
	private static int PoidsEnMilligramme = 15;
	
	private int identifiant;
	private Double dureeDeVie;  //jours
    private int poids;    
    private Phase phase ;
    
    public Fourmi(int identifiant) {
		this.identifiant = identifiant;
		this.dureeDeVie = (double) 3;
		this.phase = new Oeuf(this);
		Point unpoint = new Point(100,100);
    	this.representationGraphique = InterfaceMorph.CreeFourmi(unpoint);
	}
    
    public Fourmi(int identifiant, Point unPoint) {
		this.identifiant = identifiant;
		this.dureeDeVie = (double) 3;
		this.phase = new Oeuf(this);
		this.representationGraphique = this.RepCreeFourmi(unPoint);

	}
	
	public Fourmi(int identifiant, Point unPoint, Terrain leTerrain) {
		this.identifiant = identifiant;
		this.dureeDeVie = (double) 3;
		this.phase = new Oeuf(this);
		this.terrainLie = leTerrain;
		this.representationGraphique = this.RepCreeFourmi(unPoint);
		this.terrainLie.ajouterFourmiAffichage(this);
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
	oeuf, larve, nymphe, adulte, cadavre */
	public String isPhase()
	{
		return getPhase().jeSuis();
	}
	
	//evolution, passage d'une phase a la suivante
	public void evolution()
	{
		phase = phase.phaseSuivante();
	}
	
	//calcul aléatoire vie adulte de fourmi
	public double dureeVieFourmiAdulte()
	{
		return (1.5*(1+((7*Math.random())/10)))*365;
	}
	
	//calcul aléatoire vie adulte de reine
	public double dureeVieFourmiReine()
	{
		return (4*(1+((1.5*Math.random())/10)))*365;
	}
	
	public void seDeplacer() {		
		if(this.phase.jeSuis().equals("adulte")) {
			Adulte unAdulte = (Adulte)this.phase;
			Morph old = this.representationGraphique;
			this.representationGraphique.setPosition(unAdulte.seDeplacer(this.representationGraphique.getPosition()));  
			this.terrainLie.updateEtreVivant(old, this.representationGraphique);
		}
	}
	
	/**
	 * Fonctions de changement de rôle : 
	 * */
	
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

	//creer la representation graphique d'une fourmie. 
	//Invisible au depart, la representation evoluera 
	//grâce aux actions realisées sur la fourmi
	  public Morph RepCreeFourmi(Point pos) {
		  Dimension dim = new Dimension(0, 0);
		  return new Oval(Color.WHITE,pos,dim);
	  }
	
	  
	//met a jour les informations de la fourmi par heure, 
	//notamment son deplacement  
	//fonctionne grâce à l'héritage d'objet graphique, qui a un role d'observer  
	@Override
	public void updateH() {
		Phase unephase = this.getPhase();
		if(unephase.jeSuis().equals("adulte")) {
			this.seDeplacer();
			
			//Adulte unAdulte = (Adulte)unephase;
			//unAdulte.updateH();
		}
	}

	//met a jour les informations de la fourmi par jour, 
	//notamment son deplacement  
	//fonctionne grâce à l'héritage d'objet graphique, qui a un role d'observer  
	@Override
	public void updateJ() {
		//realise le viellissement
		try {
			this.vivre();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Phase unephase = this.getPhase();
		if(unephase.jeSuis().equals("adulte")) {
			Adulte unAdulte = (Adulte)unephase;
			this.seDeplacer();
			unAdulte.updateJ();
		}
	}

	//repercute les calculs des poids
	//en fonction de la phase de la fourmi
	public double calculPoids() {
		return this.phase.calculPoids();
	}
}