package Trace;

import modele.Coordonnees;
import modele.ObjetGraphique;

public abstract class Pheromone extends ObjetGraphique {

	Pheromone(Coordonnees unecoor){
		this.coordonnees.setCoordonneeX(unecoor.getCoordonneeX());
		this.coordonnees.setCoordonneeY(unecoor.getCoordonneeY());
	}
	
	


}
