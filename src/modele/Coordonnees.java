package modele;

public class Coordonnees {
  private int coordonneeX;
  private int coordonneeY;
  
  public Coordonnees(int X, int Y) {
    this.coordonneeX = X;
    this.coordonneeY = Y;
  }
  
  public int getCoordonneeX() {
    return coordonneeX;
  }
  public void setCoordonneeX(int coordonneeX) {
    this.coordonneeX = coordonneeX;
  }
  public int getCoordonneeY() {
    return coordonneeY;
  }
  public void setCoordonneeY(int coordonneeY) {
    this.coordonneeY = coordonneeY;
  }
  
}
