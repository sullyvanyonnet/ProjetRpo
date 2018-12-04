package modele;

public abstract class ObjetGraphique implements Observateur{

  protected Coordonnees coordonnees;
  
  public void seDeplacer() {}
  
  public Coordonnees getCoordonnees() {
    return this.coordonnees;
  }
  
  public void setCoordonnees(Coordonnees coord) {
    this.coordonnees = coord;
  }
  
  
}
