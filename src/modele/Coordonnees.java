package modele;

public class Coordonnees {
  private int coordonneeX;
  private int coordonneeY;
  
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
  
  public boolean equals(Coordonnees UneCoordonnees) {
	    if(UneCoordonnees.getCoordonneeX() == this.getCoordonneeX()) {
	    	if(UneCoordonnees.getCoordonneeY() == this.getCoordonneeY()) {
	    		return true;
	    	}
	    return false;
	    }
	return false;
  }
}
