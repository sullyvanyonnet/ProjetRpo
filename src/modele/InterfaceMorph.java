package modele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import vue.Morph;
import vue.Oval;

/**
 * La classe renvoie un Morph différent selon la méthode appelée.
 */
public abstract class InterfaceMorph {

	/**
	 * Renvoie un Morph de Proie.
	 * @param pos : position de la Proie
	 * @return Morph : le Morph crée
	 */
	static public Morph CreeProie(Point pos) {
		Dimension dim = new Dimension(3, 3);
		return new Oval(Color.GREEN, pos, dim);
	}

	/**
	 * Renvoie un Morph de Fourmi basique.
	 * @param pos : position de la Fourmi
	 * @return Morph : le Morph crée
	 */
	static public Morph CreeFourmi(Point pos) {
		Dimension dim = new Dimension(3, 3);
		return new Oval(Color.RED, pos, dim);
	}

	/**
	 * Renvoie un Morph de Fourmiliere basique.
	 * @param pos : position de la Fourmiliere
	 * @return Morph : le Morph crée
	 */
	static public Morph CreeFourmiliere(Point pos) {
		return new Oval(Color.BLACK, pos, new Dimension(20, 20));
	}

}
