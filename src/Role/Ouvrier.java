package Role;
import Fourmi.Fourmi;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

public class Ouvrier extends Role{
	
	Boolean rentreer = false;
	Stack<Point> PilePoint = new Stack<Point>(); 
	
	public Ouvrier(Fourmi fourmi) {
	   	super(fourmi);
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
