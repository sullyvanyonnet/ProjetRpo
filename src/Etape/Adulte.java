package Etape;

public class Adulte extends Phase {
  
  /**
   * Bornes de déplacement :
   * 0.00 / 0.25 : gauche
   * 0.25 / 0.50 : droite
   * 0.50 / 0.75 : haut
   * 0.75 / 1.00 : bas
   */
  public void seDeplacer() {
    double direction = Math.random();
    
    if(direction < 0.25) {
      
    }
  }
  
  public void seNourrir() {
    
  }
}
