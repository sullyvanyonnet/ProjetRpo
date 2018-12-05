package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Etape.Adulte;
import Fourmi.Fourmi;
import modele.Coordonnees;
import modele.Fourmiliere;
import modele.ObjetGraphique;
import vue.IMovableDrawable;
import vue.Oval;
import vue.World;

public class testGraphique {

	public static void main(String[] args) {
		Random x = new Random();
		World jc = new World("Un essai de Fourmilière");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800, 600));
		Dimension dim = new Dimension(5, 5);
		
		Fourmiliere newYork = new Fourmiliere();

		int xFourmiliere = newYork.getCoordonnees().getCoordonneeX();
		int yFourmiliere = newYork.getCoordonnees().getCoordonneeY();
		jc.contents().put(-1, new Oval(Color.BLACK, new Point(xFourmiliere, yFourmiliere), new Dimension(20, 20)));

		List<Fourmi> listFourmis = new ArrayList<Fourmi>();
		List<Adulte> listAdulte = new ArrayList<Adulte>();
		
		
		for (int i = 0; i < 100; i++) {
			Fourmi newFourmi = new Fourmi(i);
			newFourmi.evolutionAdulte();
			listFourmis.add(newFourmi);
			newYork.ajouterFourmi();
			
			if (listFourmis.get(i).isPhase().equals("adulte")){
				listAdulte.add((Adulte)listFourmis.get(i).getPhase());
			}
			listAdulte.get(i).setCoordonnees(new Coordonnees(100, 100));
		}


		for (int i = 0; i < 100; i++) {
			int xFourmi = listAdulte.get(i).getCoordonnees().getCoordonneeX();
			int yFourmi = listAdulte.get(i).getCoordonnees().getCoordonneeY();
			dim = new Dimension(5, 5);
			jc.contents().put(i, new Oval(Color.RED, new Point(xFourmi, yFourmi), dim));
		}
		
		List<ObjetGraphique> mesObjetsGraphiques = new ArrayList<ObjetGraphique>();
		mesObjetsGraphiques.add(newYork);
		for (int i = 0; i < 100; i++) {
			mesObjetsGraphiques.add(listAdulte.get(i));
		}
		
		jc.open();
		while (true) {
			HashMap<Integer, IMovableDrawable> drawables = jc.contents();
			
			for (int i = 0; i < mesObjetsGraphiques.size(); i++) {
				
				mesObjetsGraphiques.get(i).seDeplacer();
				int coordonneeX = mesObjetsGraphiques.get(i).getCoordonnees().getCoordonneeX();
				int coordonneeY = mesObjetsGraphiques.get(i).getCoordonnees().getCoordonneeY();
				
				IMovableDrawable unObjet = drawables.get(i);

				unObjet.setPosition(new Point(coordonneeX, coordonneeY));
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jc.repaint();
		}
	}

}
