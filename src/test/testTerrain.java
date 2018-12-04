package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
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

	public static void main(String[] args) {
		Terrain monTerrain = new Terrain();
		Dimension dim = new Dimension(5, 5);

		ArrayList<Fourmiliere> lesFourmilieres = monTerrain.getLesFourmilieres();
		int xFourmiliere = lesFourmilieres.get(0).getCoordonnees().getCoordonneeX();
		int yFourmiliere = lesFourmilieres.get(0).getCoordonnees().getCoordonneeY();
		monTerrain.getLeJardin().add(new Oval(Color.BLACK, new Point(xFourmiliere, yFourmiliere), new Dimension(20, 20)));

		List<Fourmi> listFourmis = new ArrayList<Fourmi>();
		List<Adulte> listAdulte = new ArrayList<Adulte>();
		
		
		for (int i = 0; i < 100; i++) {
			Fourmi newFourmi = new Fourmi(i);
			newFourmi.evolutionAdulte();
			listFourmis.add(newFourmi);
			lesFourmilieres.get(0).ajouterFourmi();
			
			if (listFourmis.get(i).isPhase().equals("adulte")){
				listAdulte.add((Adulte)listFourmis.get(i).getPhase());
			}
			listAdulte.get(i).setCoordonnees(new Coordonnees(xFourmiliere, yFourmiliere));
		}


		for (int i = 0; i < 100; i++) {
			int xFourmi = listAdulte.get(i).getCoordonnees().getCoordonneeX();
			int yFourmi = listAdulte.get(i).getCoordonnees().getCoordonneeY();
			dim = new Dimension(5, 5);
			monTerrain.getLeJardin().add(new Oval(Color.RED, new Point(xFourmi, yFourmi), dim));
		}
		
		List<ObjetGraphique> mesObjetsGraphiques = new ArrayList<ObjetGraphique>();
		mesObjetsGraphiques.add(lesFourmilieres.get(0));
		for (int i = 0; i < 100; i++) {
			mesObjetsGraphiques.add(listAdulte.get(i));
		}
		
		monTerrain.getLeJardin().open();
		while (true) {
			List<IMovableDrawable> drawables = monTerrain.getLeJardin().contents();
			
			for (int i = 0; i < mesObjetsGraphiques.size(); i++) {
				
				mesObjetsGraphiques.get(i).seDeplacer();
				int coordonneeX = mesObjetsGraphiques.get(i).getCoordonnees().getCoordonneeX();
				int coordonneeY = mesObjetsGraphiques.get(i).getCoordonnees().getCoordonneeY();
				
				IMovableDrawable unObjet = drawables.get(i);

				unObjet.setPosition(new Point(coordonneeX, coordonneeY));
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			monTerrain.getLeJardin().repaint();
		}
	}

}
