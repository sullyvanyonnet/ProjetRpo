package modele;

import java.awt.Point;

import vue.Morph;

public abstract class EtreVivant implements Observateur{

  protected Morph representationGraphique;
  
  public void seDeplacer() {}
  
 public Point getCoordonnees() {
    return this.representationGraphique.getPosition();
  } 
  
  public void setCoordonnees(Point coord) {
    this.representationGraphique.setPosition(coord);
  }
  
}
