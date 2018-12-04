package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Etape.Adulte;
import Fourmi.Fourmi;
import modele.Coordonnees;
import modele.Fourmiliere;
import vue.IMovableDrawable;
import vue.Oval;
import vue.World;

public class testGraphique {

	public static void main(String[] args) {
		Random x = new Random();
		World jc = new World("Un essai de Morphs");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800, 600));
		Dimension dim = new Dimension(5, 5);
		
		Fourmiliere newYork = new Fourmiliere();

		int xFourmiliere = newYork.getCoordonnees().getCoordonneeX();
		int yFourmiliere = newYork.getCoordonnees().getCoordonneeY();
		jc.add(new Oval(Color.RED, new Point(xFourmiliere, yFourmiliere), new Dimension(20, 20)));
		
		Fourmi[] tabFourmis = new Fourmi[100];
		Adulte[] tabAdultes = new Adulte[100];
		
		
		for (int i = 0; i < 100; i++) {
			tabFourmis[i] = newYork.ajouterFourmi();
			tabFourmis[i].evolutionAdulte();
			tabAdultes[i] = tabFourmis[i].isAdult();
			tabAdultes[i].setCoordonnees(new Coordonnees(100, 100));
		}


		for (int i = 0; i < 100; i++) {
			int xFourmi = tabAdultes[i].getCoordonnees().getCoordonneeX();
			int yFourmi = tabAdultes[i].getCoordonnees().getCoordonneeY();
			dim = new Dimension(5, 5);
			jc.add(new Oval(Color.RED, new Point(xFourmi, yFourmi), dim));
		}
		/*
		while (true) {
			for (int i = 0; i < 100; i++) {
				tabAdultes[i].seDeplacer();
				System.out.println("Fourmi " + i + " : " + tabAdultes[i].toString());
			}
			TimeUnit.MILLISECONDS.sleep(100);
			System.out.println();
		}
*/
		jc.open();
		while (true) {
			List<IMovableDrawable> drawables = jc.contents();
			
			for (int i = 0; i < 100; i++) {
				tabAdultes[i].seDeplacer();
				int xFourmi = tabAdultes[i].getCoordonnees().getCoordonneeX();
				int yFourmi = tabAdultes[i].getCoordonnees().getCoordonneeY();
				
				IMovableDrawable unObjet = drawables.get(i+1);

				unObjet.setPosition(new Point(xFourmi, yFourmi));
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jc.repaint();
		}
	}

}
