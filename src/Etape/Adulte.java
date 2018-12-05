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
    double direction = Math.random();
    Point retourCoordonnees = point;
    if(direction < 0.25) {
    	retourCoordonnees.setLocation(point.getX() - 1, point.getY());
    } else if (direction < 0.50) {
    	retourCoordonnees.setLocation(point.getX() + 1, point.getY());
    } else if (direction < 0.75) {
    	retourCoordonnees.setLocation(point.getX() ,point.getY() + 1);
    } else if (direction < 1.00) {
    	retourCoordonnees.setLocation(point.getX() ,point.getY() - 1);
    }
    return retourCoordonnees;
  }
  

  
  public void seNourrir() {
    
  }

  @Override
  public String jeSuis() {
	  return "adulte";
  }
  public String toString() {
    StringBuilder res = new StringBuilder("");
    res.append(this.representationGraphique.getPosition().getX() + " ");
    res.append(this.representationGraphique.getPosition().getY()  + " ");
    
    return res.toString();
    
  }
  
	@Override
	public void updateH() {
		// TODO Auto-generated method stub	
		this.seDeplacer();
	}

	@Override
	public void updateJ() {
		// TODO Auto-generated method stub
		
	}
}