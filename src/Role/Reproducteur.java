package Role;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import Fourmi.Fourmi;
import vue.Morph;
import vue.Oval;

public class Reproducteur extends Role {
	public Reproducteur(Fourmi fourmi) {
		super(fourmi);
		this.fourmi.setRepresentationGraphique(this.RepCreeFourmi());
	}

	@Override
	public String monRole() {
		return "reproducteur";
	}

	@Override
	public Point sedeplacer(Point unPoint) {
		Point retourCoordonnees = unPoint;
		double direction = Math.random();
		if (direction < 0.25) {
			retourCoordonnees.setLocation(unPoint.getX() - 5, unPoint.getY());
		} else if (direction < 0.50) {
			retourCoordonnees.setLocation(unPoint.getX() + 5, unPoint.getY());
		} else if (direction < 0.75) {
			retourCoordonnees.setLocation(unPoint.getX(), unPoint.getY() + 5);
		} else if (direction < 1.00) {
			retourCoordonnees.setLocation(unPoint.getX(), unPoint.getY() - 5);
		}
		return retourCoordonnees;
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