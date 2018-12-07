package Role;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import Fourmi.Fourmi;
import vue.Morph;
import vue.Oval;

public class Reproducteur extends Role{
	public Reproducteur(Fourmi fourmi) {
    	super(fourmi);
	   	this.fourmi.setRepresentationGraphique(this.RepCreeFourmi());
    }
	
	@Override		
	public String monRole()
	{
		return "reproducteur";
	}
	
	public Morph RepCreeFourmi() {
		Point pos = this.fourmi.getrepresentationGraphique().getPosition();
		Dimension dim = new Dimension(5, 5);
		return new Oval(Color.RED, pos, dim);
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