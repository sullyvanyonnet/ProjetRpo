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
import modele.InterfaceMorph;
import modele.EtreVivant;
import vue.IMovableDrawable;
import vue.Oval;
import vue.World;

public class testGraphique {

	public static void main(String[] args) {
		Random x = new Random();
		World jc = new World("Un essai de Fourmili�re");
		jc.setBackground(Color.WHITE);
		jc.setPreferredSize(new Dimension(800, 600));
		Dimension dim = new Dimension(5, 5);
		
		Fourmiliere newYork = new Fourmiliere();

		int xFourmiliere =(int) newYork.getrepresentationGraphique().getPosition().getX();
		int yFourmiliere =(int)  newYork.getrepresentationGraphique().getPosition().getY();
		Point pos =  new Point(xFourmiliere, yFourmiliere);
		jc.contents().put(-1, InterfaceMorph.CreeFourmiliere(pos)) ;

		List<Fourmi> listFourmis = new ArrayList<Fourmi>();
		List<Fourmi> listAdulte = new ArrayList<Fourmi>();
		
		
		for (int i = 0; i < 100; i++) {
			Fourmi newFourmi = new Fourmi(i,pos);
			newFourmi.evolution();
			listFourmis.add(newFourmi);
			newYork.ajouterFourmi();
			
			if (listFourmis.get(i).isPhase().equals("adulte")){
				listAdulte.add(listFourmis.get(i));
			}
			listAdulte.get(i).setCoordonnees(new Point(100, 100));
		}


		for (int i = 0; i < 100; i++) {
			int xFourmi = (int)listAdulte.get(i).getrepresentationGraphique().getPosition().getX();
			int yFourmi = (int)listAdulte.get(i).getrepresentationGraphique().getPosition().getY();
			dim = new Dimension(5, 5);
			Point posiFourm = new Point(xFourmi, yFourmi);
			jc.contents().put(i,InterfaceMorph.CreeFourmiliere(posiFourm));
		}
		
		List<EtreVivant> mesObjetsGraphiques = new ArrayList<EtreVivant>();
		mesObjetsGraphiques.add(newYork);
		for (int i = 0; i < 100; i++) {
			mesObjetsGraphiques.add(listAdulte.get(i));
		}
		
		jc.open();
		while (true) {
			HashMap<Integer, IMovableDrawable> drawables = jc.contents();
			
			for (int i = 0; i < mesObjetsGraphiques.size(); i++) {
				
				mesObjetsGraphiques.get(i).seDeplacer();
				int coordonneeX = (int) mesObjetsGraphiques.get(i).getrepresentationGraphique().getPosition().getX();
				int coordonneeY = (int)mesObjetsGraphiques.get(i).getrepresentationGraphique().getPosition().getY();
				
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
