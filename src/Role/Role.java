package Role;

import modele.Observateur;

import java.awt.Point;

import Etape.Oeuf;
import Fourmi.Fourmi;

public abstract class Role implements Observateur{	
	
	private Fourmi fourmi;
	
	
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

	public double dureeVieFourmiReine() {		
		return (Double) null;
	}
	
	@Override
	public void updateH() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateJ() {
		// TODO Auto-generated method stub
		
	}
}