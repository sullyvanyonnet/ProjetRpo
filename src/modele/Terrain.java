package modele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

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
		this.leJardin.add(new Oval(Color.BLACK, new Point(xFourmiliere, yFourmiliere), new Dimension(20, 20)));
		
		
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
			this.lesFourmilieres.get(i).update();
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
