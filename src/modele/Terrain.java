package modele;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import vue.IMovableDrawable;
import vue.Oval;
import vue.World;

public class Terrain extends JFrame implements Observateur {

	private final JSplitPane splitPane; // split the window in top and bottom
	private final JPanel topPanel; // container panel for the top
	private final JPanel bottomPanel; // container panel for the bottom

	private World leJardin;
	private JTree tree;
	private ArrayList<Fourmiliere> lesFourmilieres = new ArrayList<Fourmiliere>();

	public Terrain() {
		
		splitPane = new JSplitPane();
		topPanel = new JPanel();         // our top component
        bottomPanel = new JPanel();      // our bottom component
		
        getContentPane().setLayout(new GridLayout());
		this.leJardin = new World("Le Jardin");
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Fourmilieres");
		this.tree = new JTree(top);

		Fourmiliere uneFourmiliere = new Fourmiliere();
		setPreferredSize(new Dimension(1200, 800));
		getContentPane().add(splitPane);
		
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(800);
        splitPane.setLeftComponent(leJardin);
        splitPane.setRightComponent(tree);

        pack();
        
        this.leJardin.setBackground(Color.WHITE);
		this.leJardin.setPreferredSize(new Dimension(800, 800));
		
		this.lesFourmilieres.add(uneFourmiliere);

		int xFourmiliere = uneFourmiliere.getCoordonnees().getCoordonneeX();
		int yFourmiliere = uneFourmiliere.getCoordonnees().getCoordonneeY();
		this.leJardin.contents().put(-1,
				new Oval(Color.BLACK, new Point(xFourmiliere, yFourmiliere), new Dimension(20, 20)));

		for (int i = 0; i < this.lesFourmilieres.get(0).listeDeFourmis.size(); i++) {
			this.lesFourmilieres.get(0).listeDeFourmis.get(i)
					.setCoordonnees(new Coordonnees(xFourmiliere, yFourmiliere));
		}

		
		this.tree.setPreferredSize(new Dimension(200, 800));

	}

	public void open() {
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(wa);
		setVisible(true);
	}

	
	public ArrayList<Fourmiliere> getLesFourmilieres() {
		return this.lesFourmilieres;
	}

	public World getLeJardin() {
		return this.leJardin;
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.lesFourmilieres.size(); i++) {
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
				if (lesFourmilieres.get(i).listeDeFourmis.get(x).isPhase().equals("adulte")) {
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
