package Role;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import Fourmi.Fourmi;
import vue.Morph;
import vue.Oval;

public class Soldat extends Role {
	public Soldat(Fourmi fourmi) {
		super(fourmi);
		this.fourmi.setRepresentationGraphique(this.RepCreeFourmi());
	}

	@Override
	public String monRole() {
		return "soldat";
	}

	@Override
	public Point sedeplacer(Point unPoint) {
		Point retourCoordonnees = unPoint;
		double direction = Math.random();
		if (direction < 0.25) {
			Point newPoint = new Point((int) unPoint.getX() - 2, (int) unPoint.getY());
			if (checkDistanceFourmiliere(newPoint)) {
				retourCoordonnees.setLocation(newPoint.getX(), newPoint.getY());
			}
		} else if (direction < 0.50) {
			Point newPoint = new Point((int) unPoint.getX() + 2, (int) unPoint.getY());
			if (checkDistanceFourmiliere(newPoint)) {
				retourCoordonnees.setLocation(newPoint.getX(), newPoint.getY());
			}
		} else if (direction < 0.75) {
			Point newPoint = new Point((int) unPoint.getX(), (int) unPoint.getY() + 2);
			if (checkDistanceFourmiliere(newPoint)) {
				retourCoordonnees.setLocation(newPoint.getX(), newPoint.getY());
			}
		} else if (direction < 1.00) {
			Point newPoint = new Point((int) unPoint.getX(), (int) unPoint.getY() - 2);
			if (checkDistanceFourmiliere(newPoint)) {
				retourCoordonnees.setLocation(newPoint.getX(), newPoint.getY());
			}
		}
		return retourCoordonnees;
	}

	/**
	 * Vérifie si la fourmi soldat ne s'eloigne pas trop
	 * de la fourmiliere et empeche son deplacement sinon.
	 * @param newPoint : coordonnée modifiée potentielle de la fourmi
	 * @return : autorisation ou non de se déplacer
	 */
	private boolean checkDistanceFourmiliere(Point newPoint) {
		double xFourmiliere = this.fourmi.getTerrainLie().getLaFourmilieres().getCoordonnees().getX();
		double yFourmiliere = this.fourmi.getTerrainLie().getLaFourmilieres().getCoordonnees().getY();
		if (newPoint.getX() > xFourmiliere + 30 || 
				newPoint.getX() < xFourmiliere - 30 || 
				newPoint.getY() > yFourmiliere + 30 || 
				newPoint.getY() < yFourmiliere - 30) {
			return false;
		}
		return true;
	}
	
	public Morph RepCreeFourmi() {
		Point pos = this.fourmi.getrepresentationGraphique().getPosition();
		Dimension dim = new Dimension(5, 5);
		return new Oval(Color.GREEN, pos, dim);
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