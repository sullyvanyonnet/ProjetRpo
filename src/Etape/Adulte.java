package Etape;

import javax.management.relation.Role;

import Role.*;

public class Adulte extends Phase {	
	
	private Role role ;
	
	public Adulte() {
		super();
	}
	
	//devenirReine
	//devenirOuvriere
	//devenirSoldat
	//devenirReproducteur
  
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
}