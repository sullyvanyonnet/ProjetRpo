package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Fourmi.Fourmi;
import Piece.Decharge;
import Piece.Salle;
import Piece.Stock;
import Role.Reine;

public class Fourmiliere extends EtreVivant {
	List<Fourmi> listeDeFourmis;
	List<Salle> ListeSalle;
	Fourmi saMajeste;
	private int nombreDeFourmi;

	public Fourmiliere() {
		this.listeDeFourmis = new ArrayList<>();
		this.representationGraphique = InterfaceMoph.CreeFourmiliere(new Point(100, 100));
		Fourmi uneFourmi = new Fourmi(nombreDeFourmi,this.representationGraphique.getPosition());
		uneFourmi.devenirReine();		
		this.saMajeste = uneFourmi;

		this.ListeSalle = new ArrayList<>();
		this.ListeSalle.add(new Stock());
		this.ListeSalle.add(new Decharge());
		this.nombreDeFourmi = 0;
		
		for (int i = 0; i < 100; i++) {
			this.ajouterFourmi();
		}
	}

	public List<Fourmi> getFourmis() {
		return this.listeDeFourmis;
	}

	public String resumeFourmi() {
		StringBuilder res = new StringBuilder();
		return res.toString();
	}

	public Fourmi ajouterFourmi() {
		Fourmi newFourmi = new Fourmi(this.nombreDeFourmi,new Point((int) this.representationGraphique.getPosition().getX(), ((int) this.representationGraphique.getPosition().getY())));
		listeDeFourmis.add(newFourmi);
		this.nombreDeFourmi++;
		return newFourmi;
	}

	public void nourir() {
		int sommeANourir = 0;
		// get somme
		for (int i = 0; i > this.listeDeFourmis.size(); i++) {
			sommeANourir = sommeANourir + this.listeDeFourmis.get(i).getPoids();
		}
		// todo debiter
	}

	@Override
	public void updateH() {
		for(int i = 0 ; i < this.listeDeFourmis.size(); i++) {
			listeDeFourmis.get(i).updateH();
		}
	}

	@Override
	public void updateJ() {
		for(int i = 0 ; i < this.listeDeFourmis.size(); i++) {
			listeDeFourmis.get(i).updateJ();
		}
	}

}
