package Trace;

import modele.Coordonnees;
import modele.EtreVivant;

public abstract class Pheromone extends EtreVivant {
	String ID ;
	
	Pheromone(Coordonnees unecoor){
		this.ID = Integer.toString(unecoor.getCoordonneeX()) + Integer.toString(unecoor.getCoordonneeY());
	}
	
	


}
