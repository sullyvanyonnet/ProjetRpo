package Etape;

import java.awt.Point;

import Etape.*;
import Fourmi.Fourmi;
import Role.*;
import vue.Morph;

public class Adulte extends Phase {
	private Role role ;
	private double dureeAdulte;
	
	//contructeur avec 1 parametre
	public Adulte(Fourmi fourmi) {
		//utilise le contructeur de phase
		super(fourmi);
		//defini le temps de vie de la fourmi
		double tempsVie = fourmi.dureeVieFourmiAdulte();
		this.dureeAdulte = tempsVie;
		fourmi.setDureeDeVie(tempsVie);
		//defini le point de la fourmit
		fourmi.setPoids(calculPoids());
		//sauvegarde l'ancien forme graphique de la fourmi
		Morph old = this.fourmi.getrepresentationGraphique();
		//defini le role de la fourmi
		this.DefRole(fourmi);
		//demande la mise a jour sur L'IHM avec l'ancien model et le nouveau
		this.fourmi.getTerrainLie().updateEtreVivant(old, this.fourmi.getrepresentationGraphique());

	}
	//defini le role de la fourmi en fonction des probabilités 
	public void DefRole(Fourmi fourmi) {
		//genere un nombre aleatoir entre 0 et 1
		double randRole = Math.random();
		//test si le nombre plus petit que 0.70 qui correspond à 70%
	    if(randRole < 0.70) {
	    	//attribut le role ouvrier
	    	devenirOuvrier();
	    	//test si le nombre plus petit que 0.90qui correspond à 20%
	    } else if (randRole < 0.90) {
	    	//attribut le role solda
	    	devenirSoldat();
	    	//test si le nombre plus petit que 1.00qui correspond à 10%
	    } else if (randRole < 1.00) {
	    	//attribut le role Reproducteur
	    	devenirReproducteur();
	    }  
		
	}
	
	public int calculPoids()
	{
		//fonction pour generer un poid aleatoir 15 et 20
		return ((int) (15*(1+((1/3)*Math.random()))));
	}
	//permet de definire la phase suivante 
	public Phase phaseSuivante() {
		//si la fourmi lui reste du temps dans ca phase retour l'objet courant
		if (this.fourmi.getDureeDeVie() > this.dureeAdulte) return this;
		//sinon retour la creation de la phase suivante 
		return new Cadavre(fourmi);
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Object role) {
		this.role = (Role)role;
	}
	
	//sert a resoudre 
	//l'utilisation de instance of
	public String leRole()
	{
		Role role = getRole();
		String res = role.monRole();
		return res;
	}
	
	//permet a la fourmi de devenir reine
	public boolean devenirReine()
	{	
		if("adulte".equals(this.jeSuis()))
		{
			Reine reine = new Reine(super.fourmi);
			this.setRole(reine);
			return true;
		}	
		return false;
	}
	//permet a la fourmi de devenir Ouvriere
	public boolean devenirOuvrier()
	{
		if(this.jeSuis().equals("adulte"))
		{
			Ouvrier ouvrier = new Ouvrier(super.fourmi);
			this.setRole(ouvrier);
			return true;
		}
		return false;
	}
	//permet a la fourmi de devenir Soldat
	public boolean devenirSoldat()
	{
		if(this.jeSuis().equals("adulte"))
		{
			Soldat soldat = new Soldat(super.fourmi);;
			this.setRole(soldat);
			return true;
		}
		return false;
	}
	//permet a la fourmi de devenir Reproducteur
	public boolean devenirReproducteur()
	{
		if(this.jeSuis().equals("adulte"))
		{
			Reproducteur reproducteur = new Reproducteur(super.fourmi);
			this.setRole(reproducteur);
			return true;
		} 
		return false;
	}
  
  /**
   * Deplacement de base sans gestion des hormones
   * Bornes de déplacement :
   * 0.00 / 0.25 : gauche
   * 0.25 / 0.50 : droite
   * 0.50 / 0.75 : haut
   * 0.75 / 1.00 : bas
   */
	//demande a la fourmi de se deplacer en fonction de son role. Prend en parametre son point courant et retourne le point atterit  
  public Point seDeplacer(Point point) {
	
	  return this.role.sedeplacer(point);
  }
  

  //TODO
  //si ne se nourri pas dans la journée, meurt, cf. gestion du temps
  public void seNourrir() {
	  //consommer 1/3 de son propre poids dans le stock
	  //nettoyer 1 ou 2 cadavres    
  }
  
  //TODO 
  //fonction appelée par se nourrir
  //peut aussi être appelée dans le cas où il y trop de cadavres 
  //par rapport à la population de la fourmilliere (cf. decharge)
  public void nettoyerCadavre()
  {
	  //nettoyer un voir deux cadavres (aléatoire)
  }
  //retour la phase de la fourmi en chaine de charactere 
  @Override
  public String jeSuis() {
	  return "adulte";
  }
  //retourne une position en chaine de charactere
  public String toString() {
    StringBuilder res = new StringBuilder("");
    res.append(this.fourmi.getrepresentationGraphique().getPosition().getX() + " ");
    res.append(this.fourmi.getrepresentationGraphique().getPosition().getY()  + " ");
    
    return res.toString();
    
  }
  
  	//permet de definir les action a realiser toutes les heurs
	@Override
	public void updateH() {
		this.role.updateH();		
	}
	
  	//permet de definir les action a realiser toutes les jours
	@Override
	public void updateJ() {
		this.role.updateJ();		
	}
}