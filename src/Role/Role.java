package Role;

import modele.Observateur;
import vue.Morph;

import java.awt.Point;

import Etape.Oeuf;
import Fourmi.Fourmi;

public abstract class Role implements Observateur{	
	
	protected Fourmi fourmi;
	
	/**
	 * Methode d�crivant le d�placement de base d'une fourmi.
	 * @param unPoint : position de base de la fourmi
	 * @return Point : coordonn�e modifi�e de la fourmi
	 */
	public Point sedeplacer(Point unPoint){
	    Point retourCoordonnees = unPoint;
		    double direction = Math.random();	    
		    if(direction < 0.25) {
		    	retourCoordonnees.setLocation(unPoint.getX() - 1, unPoint.getY());
		    } else if (direction < 0.50) {
		    	retourCoordonnees.setLocation(unPoint.getX() + 1, unPoint.getY());
		    } else if (direction < 0.75) {
		    	retourCoordonnees.setLocation(unPoint.getX() ,unPoint.getY() + 1);
		    } else if (direction < 1.00) {
		    	retourCoordonnees.setLocation(unPoint.getX() ,unPoint.getY() - 1);
		    }
		return retourCoordonnees;
	}
	
	public Role(Fourmi fourmi)
	{
		this.fourmi = fourmi ;
	}

	public String monRole() {
		return null;
	}

	public Oeuf pondre() {		
		return null;
	}

	public Morph RepCreeFourmi() {
		return null;  
	}
	
	/*
	@SuppressWarnings("null")
	public double dureeVieFourmiReine() {		
		return (Double) null;
	}
	*/
	
	@Override
	public void updateH() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateJ() {
		// TODO Auto-generated method stub
		
	}
}