package Etape;

import Etape.*;
import Fourmi.Fourmi;
import Role.*;

public class Adulte extends Phase {
	private Role role ;
	private double dureeAdulte;
	
	public Adulte(Fourmi fourmi) {
		super(fourmi);
		this.dureeAdulte = fourmi.dureeVieFourmiAdulte();
	}
	
	public Phase phaseSuivante() {
		if (this.fourmi.getDureeDeVie() < this.dureeAdulte) return this;
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
			Reine reine = new Reine(fourmi);
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
			Ouvrier ouvrier = new Ouvrier(fourmi);
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
			Soldat soldat = new Soldat(fourmi);
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
			Reproducteur reproducteur = new Reproducteur(fourmi);
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
  public void seDeplacer() {
    double direction = Math.random();
    
    if(direction < 0.25) {
      this.coordonnees.setCoordonneeX(this.coordonnees.getCoordonneeX() - 1);
    } else if (direction < 0.50) {
      this.coordonnees.setCoordonneeX(this.coordonnees.getCoordonneeX() + 1);
    } else if (direction < 0.75) {
      this.coordonnees.setCoordonneeY(this.coordonnees.getCoordonneeY() + 1);
    } else if (direction < 1.00) {
      this.coordonnees.setCoordonneeY(this.coordonnees.getCoordonneeY() - 1);
    }
  }
  

  
  public void seNourrir() {
    
  }

  @Override
  public String jeSuis() {
	  return "adulte";
  }
  public String toString() {
    StringBuilder res = new StringBuilder("");
    res.append(this.coordonnees.getCoordonneeX() + " ");
    res.append(this.coordonnees.getCoordonneeY() + " ");
    
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