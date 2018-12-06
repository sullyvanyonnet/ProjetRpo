package modele;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import Fourmi.Fourmi;
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
	
	List<EtreVivant> mesObjetsGraphiques = new ArrayList<EtreVivant>();

	public Terrain() {

		initFrame();

		this.laFourmiliere = new Fourmiliere(this);
		mesObjetsGraphiques.add(laFourmiliere);
		int xFourmiliere = (int) laFourmiliere.getCoordonnees().getX();
		int yFourmiliere = (int) laFourmiliere.getCoordonnees().getY();

		this.leJardin.contents().add(new Oval(Color.BLACK, new Point(xFourmiliere, yFourmiliere), new Dimension(20, 20)));

		for (int i = 0; i < this.laFourmiliere.listeDeFourmis.size(); i++) {
			this.laFourmiliere.listeDeFourmis.get(i).setCoordonnees(new Point(xFourmiliere, yFourmiliere));
		}

		this.tree.setPreferredSize(new Dimension(200, 800));
		this.open();

	}
	
	private void miseAjourPos() {
		if (mesObjetsGraphiques.size() > 0) {

			ArrayList<IMovableDrawable> drawables = this.getLeJardin().contents();
	
			int i = 0;
			for(IMovableDrawable item : drawables) {
				int coordonneeX = (int) mesObjetsGraphiques.get(i)
						.getrepresentationGraphique().getPosition().getX();
				int coordonneeY = (int) mesObjetsGraphiques.get(i)
						.getrepresentationGraphique().getPosition().getY();
				
				IMovableDrawable unObjet = item;
	
				unObjet.setPosition(new Point(coordonneeX, coordonneeY));
			 
				i++;
			}
		}
	}
	
	private void ajouterFourmiAffichage(Fourmi unefourmi) {
		mesObjetsGraphiques.add(unefourmi);	
		int coordonneeX = (int) unefourmi.getrepresentationGraphique().getPosition().getX();
		int coordonneeY = (int) unefourmi.getrepresentationGraphique().getPosition().getY();
		//IMovableDrawable unObjet = drawables.get(i);
		this.getLeJardin().contents().add(InterfaceMorph.CreeFourmi(new Point(coordonneeX, coordonneeY)));
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
		if (index > 0) {
			this.leJardin.contents().set(index, representationGraphique);
		}
		this.leJardin.repaint();
	}
	
	public void notifyObservers() {
		// TODO Auto-generated method stub
		this.laFourmiliere.updateH();
	}

	@Override
	public void updateH() {

		// TODO Auto-generated method stub
		laFourmiliere.updateH();
		laFourmiliere.updateH();

		this.miseAjourPos();
		this.getLeJardin().repaint();
	}

	@Override
	public void updateJ() {
		laFourmiliere.updateJ();
		for (int i = 0; i < this.laFourmiliere.listeDeFourmis.size(); i++) {
			Fourmi unefourmi = laFourmiliere.getFourmis().get(i);
			if (unefourmi.isPhase().equals("nymphe")) 
			{
				try {
					unefourmi.vivre();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (unefourmi.isPhase().equals("adulte")) {
					ajouterFourmiAffichage(unefourmi);
				}
			}else {
				try {
					unefourmi.vivre();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		this.miseAjourPos();

		this.getLeJardin().repaint();
	}

}
