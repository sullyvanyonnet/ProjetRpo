package Trace;

import java.awt.Point;
import modele.ObjectGraphique;

public abstract class Pheromone extends ObjectGraphique {
	String ID ;
	
	Pheromone(Point unecoor){
		this.ID = Double.toString(unecoor.getX()) + Double.toString(unecoor.getY());
	}
	
	


}
