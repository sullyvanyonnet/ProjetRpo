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
import modele.EtreVivant;
import modele.Terrain;
import vue.IMovableDrawable;
import vue.Oval;

public class testTerrain {

	public static void main(String[] args) throws InterruptedException {
		Terrain monTerrain = new Terrain();
		Dimension dim = new Dimension(5, 5);

		ArrayList<Fourmiliere> lesFourmilieres = monTerrain.getLesFourmilieres();
		int xFourmiliere = (int) lesFourmilieres.get(0)
				.getrepresentationGraphique().getPosition().getX();
		int yFourmiliere = (int) lesFourmilieres.get(0)
				.getrepresentationGraphique().getPosition().getY();

		List<EtreVivant> mesObjetsGraphiques = new ArrayList<EtreVivant>();
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
					int coordonneeX = (int) mesObjetsGraphiques.get(i)
							.getrepresentationGraphique().getPosition().getX();
					int coordonneeY = (int) mesObjetsGraphiques.get(i)
							.getrepresentationGraphique().getPosition().getY();
					
					IMovableDrawable unObjet = value;

					unObjet.setPosition(new Point(coordonneeX, coordonneeY));
				 
					i++;
				}
				
				monTerrain.getLeJardin().repaint();

			}

			for (int i = 0; i < lesFourmilieres.get(0).getFourmis().size(); i++) {
				if (lesFourmilieres.get(0).getFourmis().get(i).isPhase().equals("nymphe")) 
				{
					lesFourmilieres.get(0).getFourmis().get(i).vivre();
					if (lesFourmilieres.get(0).getFourmis().get(i).isPhase().equals("adulte")) 
					{
						mesObjetsGraphiques.add(lesFourmilieres.get(0).getFourmis().get(i));						
						int xFourmi = (int) lesFourmilieres.get(0).getFourmis().get(i)
								.getrepresentationGraphique().getPosition().getX();
						int yFourmi = (int) lesFourmilieres.get(0).getFourmis().get(i)
								.getrepresentationGraphique().getPosition().getY();
						dim = new Dimension(3, 3);
						//creer un nouvel objet graphique de type Fourmi dans le terrain : 
						monTerrain.getLeJardin().contents()
								.put(lesFourmilieres.get(0).getFourmis().get(i).getIdentifiant(), 
								new Oval(Color.RED, new Point(xFourmi, yFourmi), dim));
					}
				} else {
					lesFourmilieres.get(0).getFourmis().get(i).vivre();
				}
				
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(10);
				lesFourmilieres.get(0).ajouterFourmi();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
