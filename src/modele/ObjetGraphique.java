package modele;

public abstract class ObjetGraphique {

  protected Coordonnees coordonnees;
  
  protected void seDeplacer() {}
  
  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }
  
  public void setCoordonnees(Coordonnees coord) {
    this.coordonnees = coord;
  }
  
}
