package modele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vue.IMovableDrawable;
import vue.Oval;
import vue.World;

public class Terrain implements Observateur{

	private World leJardin;
	private ArrayList<Fourmiliere> lesFourmilieres = new ArrayList<Fourmiliere>();


	public Terrain(){
		this.leJardin = new World("Le Jardin");
		this.leJardin.setBackground(Color.WHITE);
		this.leJardin.setPreferredSize(new Dimension(800, 800));

		Fourmiliere uneFourmiliere = new Fourmiliere();
		this.lesFourmilieres.add(uneFourmiliere);
		
		int xFourmiliere = uneFourmiliere.getCoordonnees().getCoordonneeX();
		int yFourmiliere = uneFourmiliere.getCoordonnees().getCoordonneeY();
		this.leJardin.contents().put(-1, new Oval(Color.BLACK, new Point(xFourmiliere, yFourmiliere), new Dimension(20, 20)));
		
		for(int i = 0 ; i < this.lesFourmilieres.get(0).listeDeFourmis.size() ; i++ ) {
			this.lesFourmilieres.get(0).listeDeFourmis.get(i).setCoordonnees(new Coordonnees(xFourmiliere, yFourmiliere));
		}
		this.getLeJardin().open();
	}

	public ArrayList<Fourmiliere> getLesFourmilieres() {
		return this.lesFourmilieres;
	}
	public World getLeJardin() {
		return this.leJardin;
	}
	
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i=0;i<this.lesFourmilieres.size();i++) {
			this.lesFourmilieres.get(i).updateH();
		}
	}
	


	@Override
	public void updateH() {
		
		// TODO Auto-generated method stub
		HashMap<Integer, IMovableDrawable> drawables = this.getLeJardin().contents();
		for (int i = 0; i < this.lesFourmilieres.size(); i++) {
			lesFourmilieres.get(i).updateH();
		}

		for (int i = 0; i < this.lesFourmilieres.size(); i++) {
			
			for (int x = 0; x < this.lesFourmilieres.get(i).listeDeFourmis.size(); x++) {
				if(lesFourmilieres.get(i).listeDeFourmis.get(x).isPhase().equals("adulte")) {
					int coordonneeX = lesFourmilieres.get(i).listeDeFourmis.get(x).getCoordonnees().getCoordonneeX();
					int coordonneeY = lesFourmilieres.get(i).listeDeFourmis.get(x).getCoordonnees().getCoordonneeY();
					IMovableDrawable unObjet = drawables.get(i);
					unObjet.setPosition(new Point(coordonneeX, coordonneeY));
				}

			}
		}
		this.getLeJardin().repaint();		
	}

	@Override
	public void updateJ() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.lesFourmilieres.size(); i++) {
			lesFourmilieres.get(i).updateJ();
		}

		this.getLeJardin().repaint();	
	}

}
