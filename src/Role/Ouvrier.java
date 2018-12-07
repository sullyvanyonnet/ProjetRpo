package Role;
import Fourmi.Fourmi;
import vue.Morph;
import vue.Oval;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

public class Ouvrier extends Role{
	
	Boolean rentreer = false;
	Stack<Point> PilePoint = new Stack<Point>(); 
	
	public Ouvrier(Fourmi fourmi) {
	   	super(fourmi);
	   	this.fourmi.setRepresentationGraphique(this.RepCreeFourmi());
	}
	
	
	public void inverseBool() {
		this.rentreer = !this.rentreer;
	}
	
	@Override 
	public Point sedeplacer(Point unPoint){
	    Point retourCoordonnees = unPoint;
		if(!rentreer) {	
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
		    this.PilePoint.add(retourCoordonnees);	    
		}else {
			if(! this.PilePoint.empty()) {
				retourCoordonnees =  this.PilePoint.pop();
			}
		}
		return retourCoordonnees;
	}
	
	public Morph RepCreeFourmi() {
		Point pos = this.fourmi.getrepresentationGraphique().getPosition();
		Dimension dim = new Dimension(5, 5);
		return new Oval(Color.YELLOW, pos, dim);
	}

	@Override
    public String monRole()
	{
		return "ouvrier";
	}
	@Override
	public void updateH() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateJ() {
		this.inverseBool();		
	}
}
