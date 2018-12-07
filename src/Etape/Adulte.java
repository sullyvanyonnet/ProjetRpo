package Etape;

import java.awt.Point;

import Etape.*;
import Fourmi.Fourmi;
import Role.*;
import modele.Coordonnees;

public class Adulte extends Phase {
	private Role role ;
	private double dureeAdulte;
	
	public Adulte(Fourmi fourmi) {
		super(fourmi);
		double tempsVie = fourmi.dureeVieFourmiAdulte();
		this.dureeAdulte = tempsVie;
		fourmi.setDureeDeVie(tempsVie);
		fourmi.setPoids(calculPoids());
		this.DefRole(fourmi);
	}
	
	public void DefRole(Fourmi fourmi) {
		double randRole = Math.random();	    
	    if(randRole < 0.70) {
	    	devenirOuvrier();
	    } else if (randRole < 0.90) {
	    	devenirSoldat();
	    } else if (randRole < 1.00) {
	    	devenirReproducteur();
	    }  
		
	}
	
	public int calculPoids()
	{
		return ((int) (15*(1+((1/3)*Math.random()))));
	}
	
	public Phase phaseSuivante() {
		if (this.fourmi.getDureeDeVie() > this.dureeAdulte) return this;
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
	
	//devenirReine
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
	//devenirOuvriere
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
	//devenirSoldat
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
	//devenirReproducteur
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
  public Point seDeplacer(Point point) {
	
	  return  this.role.sedeplacer(point);
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

  @Override
  public String jeSuis() {
	  return "adulte";
  }
  public String toString() {
    StringBuilder res = new StringBuilder("");
    res.append(this.fourmi.getrepresentationGraphique().getPosition().getX() + " ");
    res.append(this.fourmi.getrepresentationGraphique().getPosition().getY()  + " ");
    
    return res.toString();
    
  }
  
	@Override
	public void updateH() {
		this.role.updateH();		
	}

	@Override
	public void updateJ() {
		this.role.updateJ();		
	}
}