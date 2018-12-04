package modele;

public abstract class ObjetGraphique {

  protected Coordonnees coordonnees;
  
  public void seDeplacer() {}
  
  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }
  
  public void setCoordonnees(Coordonnees coord) {
    this.coordonnees = coord;
  }

  public abstract void update();
  
}
