package modele;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

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
		
		for (int i = 0; i < 100 ; i++ ) {
			uneFourmiliere.ajouterFourmi();
		}	
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
