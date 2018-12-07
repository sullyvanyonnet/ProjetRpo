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

	/**
	 * Methode faisant se deplacer la fourmi reproductrice
	 */
	@Override
	public Point sedeplacer(Point unPoint) {
		Point retourCoordonnees = unPoint;
		double direction = Math.random();
		if (direction < 0.25) {
			retourCoordonnees.setLocation(unPoint.getX() - 2, unPoint.getY());
		} else if (direction < 0.50) {
			retourCoordonnees.setLocation(unPoint.getX() + 2, unPoint.getY());
		} else if (direction < 0.75) {
			retourCoordonnees.setLocation(unPoint.getX(), unPoint.getY() + 2);
		} else if (direction < 1.00) {
			retourCoordonnees.setLocation(unPoint.getX(), unPoint.getY() - 2);
		}
		return retourCoordonnees;
	}

	/**
	 * Methode qui crée un Morph correspondant à un reproducteur.
	 */
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