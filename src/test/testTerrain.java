package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Etape.Adulte;
import Fourmi.Fourmi;
import modele.Coordonnees;
import modele.Fourmiliere;
import modele.ObjetGraphique;
import modele.Terrain;
import vue.IMovableDrawable;
import vue.Oval;
import vue.World;

public class testTerrain {

	public static void main(String[] args) throws InterruptedException {
		Terrain monTerrain = new Terrain();
		Dimension dim = new Dimension(5, 5);

		ArrayList<Fourmiliere> lesFourmilieres = monTerrain.getLesFourmilieres();
		int xFourmiliere = lesFourmilieres.get(0).getCoordonnees().getCoordonneeX();
		int yFourmiliere = lesFourmilieres.get(0).getCoordonnees().getCoordonneeY();

		List<Adulte> listAdulte = new ArrayList<Adulte>();

		for (int i = 0; i < 10; i++) {
			lesFourmilieres.get(0).ajouterFourmi();
		}
		
		monTerrain.getLeJardin().open();
		while (true) {
			if (listAdulte.size() > 0) {

				List<ObjetGraphique> mesObjetsGraphiques = new ArrayList<ObjetGraphique>();
				mesObjetsGraphiques.addAll(lesFourmilieres);
				for (int i = 0; i < listAdulte.size(); i++) {
					mesObjetsGraphiques.add(listAdulte.get(i));
				}

				HashMap<Integer, IMovableDrawable> drawables = monTerrain.getLeJardin().contents();

				for (int i = 0; i < mesObjetsGraphiques.size(); i++) {

					mesObjetsGraphiques.get(i).seDeplacer();
					int coordonneeX = mesObjetsGraphiques.get(i).getCoordonnees().getCoordonneeX();
					int coordonneeY = mesObjetsGraphiques.get(i).getCoordonnees().getCoordonneeY();
//indice 10 drawable est nul
					IMovableDrawable unObjet = drawables.get(i);

					unObjet.setPosition(new Point(coordonneeX, coordonneeY));
				}

				
				monTerrain.getLeJardin().repaint();

			}

			for (int i = 0; i < lesFourmilieres.get(0).getFourmis().size(); i++) {
				if (lesFourmilieres.get(0).getFourmis().get(i).isPhase().equals("nymphe")) {
					lesFourmilieres.get(0).getFourmis().get(i).vivre();
					if (lesFourmilieres.get(0).getFourmis().get(i).isPhase().equals("adulte")) {
						listAdulte.add((Adulte) lesFourmilieres.get(0).getFourmis().get(i).getPhase());
						listAdulte.get(i).setCoordonnees(new Coordonnees(xFourmiliere, yFourmiliere));
						int xFourmi = listAdulte.get(i).getCoordonnees().getCoordonneeX();
						int yFourmi = listAdulte.get(i).getCoordonnees().getCoordonneeY();
						dim = new Dimension(3, 3);
						monTerrain.getLeJardin().contents().put(lesFourmilieres.get(0).getFourmis().get(i).getIdentifiant(), new Oval(Color.RED, new Point(xFourmi, yFourmi), dim));
					}
				} else {
					lesFourmilieres.get(0).getFourmis().get(i).vivre();
				}
				
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				Fourmi newFourmi = new Fourmi(lesFourmilieres.get(0).getFourmis().size());
				lesFourmilieres.get(0).getFourmis().add(newFourmi);
				lesFourmilieres.get(0).ajouterFourmi();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
