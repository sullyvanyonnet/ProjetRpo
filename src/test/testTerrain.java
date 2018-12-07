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

		Fourmiliere laFourmiliere = monTerrain.getLaFourmilieres();
		int xFourmiliere = (int) laFourmiliere.getrepresentationGraphique().getPosition().getX();
		int yFourmiliere = (int) laFourmiliere.getrepresentationGraphique().getPosition().getY();

		List<ObjetGraphique> mesObjetsGraphiques = new ArrayList<ObjetGraphique>();
		mesObjetsGraphiques.add(laFourmiliere);
		
		monTerrain.open();
		while (true) {
			if (mesObjetsGraphiques.size() > 0) {

				ArrayList<IMovableDrawable> drawables = monTerrain.getLeJardin().contents();

				int i = 0;
				for(IMovableDrawable item : drawables) {
				    
				    mesObjetsGraphiques.get(i).seDeplacer();
					int coordonneeX = (int) mesObjetsGraphiques.get(i)
							.getrepresentationGraphique().getPosition().getX();
					int coordonneeY = (int) mesObjetsGraphiques.get(i)
							.getrepresentationGraphique().getPosition().getY();
					
					IMovableDrawable unObjet = item;

					unObjet.setPosition(new Point(coordonneeX, coordonneeY));
				 
					i++;
				}
				
				//monTerrain.getLeJardin().repaint();

			}

			for (int i = 0; i < laFourmiliere.getFourmis().size(); i++) {
				if (laFourmiliere.getFourmis().get(i).isPhase().equals("nymphe")) 
				{
					laFourmiliere.getFourmis().get(i).vivre();
					if (laFourmiliere.getFourmis().get(i).isPhase().equals("adulte")) 
					{
						laFourmiliere.getFourmis().get(i).devenirOuvrier();
						
						mesObjetsGraphiques.add(laFourmiliere.getFourmis().get(i));	
						
						int xFourmi = (int) laFourmiliere.getFourmis().get(i)
								.getrepresentationGraphique().getPosition().getX();
						int yFourmi = (int) laFourmiliere.getFourmis().get(i)
								.getrepresentationGraphique().getPosition().getY();
						dim = new Dimension(3, 3);
						//creer un nouvel objet graphique de type Fourmi dans le terrain : 
						monTerrain.getLeJardin().contents().add(new Oval(Color.RED, new Point(xFourmi, yFourmi), dim));
					}
				} else {
					laFourmiliere.getFourmis().get(i).vivre();
				}
				
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				laFourmiliere.ajouterFourmi();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
