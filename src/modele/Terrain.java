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
import vue.Morph;
import vue.Oval;
import vue.World;

public class Terrain extends JFrame implements Observateur {

	private JSplitPane splitPane; // split the window in top and bottom
	private JPanel topPanel; // container panel for the top
	private JPanel bottomPanel; // container panel for the bottom

	private World leJardin;
	private JTree tree;
	private Fourmiliere laFourmiliere;

	public Terrain() {

		initFrame();

		this.laFourmiliere = new Fourmiliere();
		int xFourmiliere = (int) laFourmiliere.getCoordonnees().getX();
		int yFourmiliere = (int) laFourmiliere.getCoordonnees().getY();

		this.leJardin.contents().add(new Oval(Color.BLACK, new Point(xFourmiliere, yFourmiliere), new Dimension(20, 20)));

		for (int i = 0; i < this.laFourmiliere.listeDeFourmis.size(); i++) {
			this.laFourmiliere.listeDeFourmis.get(i).setCoordonnees(new Point(xFourmiliere, yFourmiliere));
		}

		this.tree.setPreferredSize(new Dimension(200, 800));

	}

	private void initFrame() {

		splitPane = new JSplitPane();
		topPanel = new JPanel();
		bottomPanel = new JPanel();

		getContentPane().setLayout(new GridLayout());
		this.leJardin = new World("Le Jardin");
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Fourmilieres");
		this.tree = new JTree(top);

		setPreferredSize(new Dimension(1200, 800));
		getContentPane().add(splitPane);

		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(800);
		splitPane.setLeftComponent(leJardin);
		splitPane.setRightComponent(tree);

		pack();

		this.leJardin.setBackground(Color.WHITE);
		this.leJardin.setPreferredSize(new Dimension(800, 800));
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

	public Fourmiliere getLaFourmilieres() {
		return this.laFourmiliere;
	}

	public World getLeJardin() {
		return this.leJardin;
	}

	public void updateEtreVivant(Morph representationGraphique) {
		int index = this.leJardin.contents().indexOf(representationGraphique);
		this.leJardin.contents().set(index, representationGraphique);
	}
	
	public void notifyObservers() {
		// TODO Auto-generated method stub
		this.laFourmiliere.updateH();
	}

	@Override
	public void updateH() {

		// TODO Auto-generated method stub
		ArrayList<IMovableDrawable> drawables = this.getLeJardin().contents();
		laFourmiliere.updateH();

		for (int i = 0; i < this.laFourmiliere.listeDeFourmis.size(); i++) {
			if (laFourmiliere.listeDeFourmis.get(i).isPhase().equals("adulte")) {
				int coordonneeX = (int) laFourmiliere.listeDeFourmis.get(i).getCoordonnees().getX();
				int coordonneeY = (int) laFourmiliere.listeDeFourmis.get(i).getCoordonnees().getY();
				IMovableDrawable unObjet = drawables.get(i);
				unObjet.setPosition(new Point(coordonneeX, coordonneeY));
			}

		}
		this.getLeJardin().repaint();
	}

	@Override
	public void updateJ() {
		laFourmiliere.updateJ();

		this.getLeJardin().repaint();
	}

}
