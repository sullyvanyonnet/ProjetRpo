package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import Etape.Adulte;
import Fourmi.Fourmi;
import modele.Coordonnees;
import modele.Fourmiliere;
import modele.ObjetGraphique;
import modele.Terrain;
import vue.IMovableDrawable;
import vue.Oval;

public class testTerrain {

	public static void main(String[] args) throws InterruptedException {
		Terrain monTerrain = new Terrain();
		Dimension dim = new Dimension(5, 5);

		ArrayList<Fourmiliere> lesFourmilieres = monTerrain.getLesFourmilieres();
		int xFourmiliere = lesFourmilieres.get(0).getCoordonnees().getCoordonneeX();
		int yFourmiliere = lesFourmilieres.get(0).getCoordonnees().getCoordonneeY();

		List<ObjetGraphique> mesObjetsGraphiques = new ArrayList<ObjetGraphique>();
		mesObjetsGraphiques.addAll(lesFourmilieres);
		
		monTerrain.open();
		while (true) {
			if (mesObjetsGraphiques.size() > 0) {

				HashMap<Integer, IMovableDrawable> drawables = monTerrain.getLeJardin().contents();

				int i = 0;
				for(Entry<Integer, IMovableDrawable> entry : drawables.entrySet()) {
					Integer key = entry.getKey();
				    IMovableDrawable value = entry.getValue();
				    
				    mesObjetsGraphiques.get(i).seDeplacer();
					int coordonneeX = mesObjetsGraphiques.get(i).getCoordonnees().getCoordonneeX();
					int coordonneeY = mesObjetsGraphiques.get(i).getCoordonnees().getCoordonneeY();
					
					IMovableDrawable unObjet = value;

					unObjet.setPosition(new Point(coordonneeX, coordonneeY));
				 
					i++;
				}
				
				monTerrain.getLeJardin().repaint();

			}

			for (int i = 0; i < lesFourmilieres.get(0).getFourmis().size(); i++) {
				if (lesFourmilieres.get(0).getFourmis().get(i).isPhase().equals("nymphe")) {
					lesFourmilieres.get(0).getFourmis().get(i).vivre();
					if (lesFourmilieres.get(0).getFourmis().get(i).isPhase().equals("adulte")) {
						mesObjetsGraphiques.add(lesFourmilieres.get(0).getFourmis().get(i));
						
						int xFourmi = lesFourmilieres.get(0).getFourmis().get(i).getCoordonnees().getCoordonneeX();
						int yFourmi = lesFourmilieres.get(0).getFourmis().get(i).getCoordonnees().getCoordonneeY();
						dim = new Dimension(3, 3);
						monTerrain.getLeJardin().contents().put(lesFourmilieres.get(0).getFourmis().get(i).getIdentifiant(), new Oval(Color.RED, new Point(xFourmi, yFourmi), dim));
					}
				} else {
					lesFourmilieres.get(0).getFourmis().get(i).vivre();
				}
				
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				lesFourmilieres.get(0).ajouterFourmi();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
