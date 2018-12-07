package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Fourmi.Fourmi;
import Piece.Decharge;
import Piece.Salle;
import Piece.Stock;

public class Fourmiliere extends ObjetGraphique {
	List<Fourmi> listeDeFourmis; //Liste des fourmis de la fourmiliere, de larve à cadavre.
	List<Salle> ListeSalle; //Liste des salles de la fourmiliere (non développée).
	Fourmi saMajeste; //Reine de la fourmiliere.
	private int nombreDeFourmi; //Nombre de fourmis dans la fourmiliere.

	public Fourmiliere(Terrain leTerrain) {
		
		this.listeDeFourmis = new ArrayList<>();
		this.representationGraphique = InterfaceMorph.CreeFourmiliere(new Point(400, 400));
		Fourmi uneFourmi = new Fourmi(nombreDeFourmi,this.representationGraphique.getPosition(), leTerrain);
		uneFourmi.devenirReine();		
		this.saMajeste = uneFourmi;

		this.ListeSalle = new ArrayList<>();
		this.ListeSalle.add(new Stock());
		this.ListeSalle.add(new Decharge());
		
		this.terrainLie = leTerrain;
		this.nombreDeFourmi = 0;
		
		for (int i = 0; i < 500; i++) {
			this.ajouterFourmi();
		}
	}

	/**
	 * Fonction permettant de recuperer la coordonnée X de la fourmiliere sur la carte.
	 * @return int : la coordonnée recherchée
	 */
	private int getX() {
		return (int) this.representationGraphique.getPosition().getX();
	}
	/**
	 * Fonction permettant de recuperer la coordonnée Y de la fourmiliere sur la carte.
	 * @return int : la coordonnée recherchée
	 */
	private int getY() {
		return (int) this.representationGraphique.getPosition().getY();
	}
	/**
	 * Fonction permettant de recuperer liste des fourmis de la fourmiliere.
	 * @return List<Fourmis> : liste des fourmis de la fourmiliere
	 */
	public List<Fourmi> getFourmis() {
		return this.listeDeFourmis;
	}

	/**
	 * Ajoute une fourmi à la fourmiliere.
	 * Elle est créée avec :
	 *		- un identifiant : le nombre de fourmis créées par la fourmiliere
	 *		- un point : les coordonnées de la fourmiliere
	 *		- un terrain : le terrain sur lequel est situé la fourmiliere
	 * la fourmi est créée à l'etat d'oeuf, et ajoutée à la liste de fourmis de la fourmiliere.
	 * 
	 * @return Fourmi : la fourmi créée.
	 */
	public Fourmi ajouterFourmi() {
		Fourmi newFourmi = new Fourmi(this.nombreDeFourmi, new Point(this.getX() ,this.getY()), this.terrainLie);
		listeDeFourmis.add(newFourmi);
		this.nombreDeFourmi++;
		return newFourmi;
	}

	/**
	 * Methode permettant aux fourmis de se nourrir dans la fourmiliere.
	 * (non développée)
	 */
	public void nourir() {
		int sommeANourir = 0;
		// get somme
		for (int i = 0; i > this.listeDeFourmis.size(); i++) {
			sommeANourir = sommeANourir + this.listeDeFourmis.get(i).getPoids();
		}
		// todo debiter
	}

	/**
	 * Methode de mise à jour horaire de la fourmiliere.
	 * Ne fait rien dans l'etat actuel.
	 * (non développée)
	 */
	@Override
	public void updateH() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Methode de mise à jour horaire de la fourmiliere.
	 * Ne fait rien dans l'etat actuel.
	 * (non développée)
	 */
	@Override
	public void updateJ() {
		// TODO Auto-generated method stub
		
	}

}
