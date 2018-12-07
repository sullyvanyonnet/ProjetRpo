package modele;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import Fourmi.Fourmi;
import proie.Araignee;
import vue.IMovableDrawable;
import vue.Morph;
import vue.Oval;
import vue.World;

public class Terrain extends JFrame implements Observateur {

	/* les panneaux qui composent la fenetre */
	private JSplitPane splitPaneGaucheDroite; // separation haut bas pour la zone de texte.
	private JSplitPane splitPaneHautBas; // separation gauche droite pour le world et l'arbre.
	private JPanel topPanel; // panneau superieur contenant le controle du temps.
	private JPanel leftPanel; // panneau de gauche contenant le World.
	private JPanel rightPanel; // panneau de droite contenant l'arbre de statistiques (non developpe)

	/* les elements du topPanel */
	private JTextField textfield;
	private JButton boutonMoins;
	private JButton boutonPlus;

	private World leJardin;
	private JTree tree;
	private Fourmiliere laFourmiliere;
	private Parametrage laPara;

	List<ObjetGraphique> mesObjetsGraphiques = new ArrayList<ObjetGraphique>();

	/**
	 * Methode mettant en place la fenetre et ses elements de base.
	 * @param unePara : Parametrage lancant la fenetre.
	 */
	public Terrain(Parametrage unePara) {

		this.laPara = unePara;

		initFrame();

		this.laFourmiliere = new Fourmiliere(this);
		mesObjetsGraphiques.add(laFourmiliere);
		int xFourmiliere = (int) laFourmiliere.getCoordonnees().getX();
		int yFourmiliere = (int) laFourmiliere.getCoordonnees().getY();

		this.leJardin.contents()
				.add(new Oval(Color.BLACK, new Point(xFourmiliere, yFourmiliere), new Dimension(40, 40)));

		for (int i = 0; i < this.laFourmiliere.listeDeFourmis.size(); i++) {
			this.laFourmiliere.listeDeFourmis.get(i).setCoordonnees(new Point(xFourmiliere, yFourmiliere));
		}

		this.tree.setPreferredSize(new Dimension(200, 800));
		this.open();

	}

	/**
	 * Initialisation de composants Swing de la fenetre.
	 */
	private void initFrame() {

		/*
		 * Les panels principaux.
		 */
		splitPaneHautBas = new JSplitPane();
		splitPaneGaucheDroite = new JSplitPane();
		topPanel = new JPanel();
		leftPanel = new JPanel();
		rightPanel = new JPanel();

		getContentPane().setLayout(new GridLayout());
		this.leJardin = new World("Le Jardin");
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Fourmilieres");
		this.tree = new JTree(top);

		setPreferredSize(new Dimension(1200, 900));

		getContentPane().add(splitPaneHautBas);

		/*
		 * Mise en place du SplitPanel haut/bas.
		 */
		splitPaneHautBas.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPaneHautBas.setDividerLocation(100);
		splitPaneHautBas.setTopComponent(topPanel);
		splitPaneHautBas.setBottomComponent(splitPaneGaucheDroite);

		/**
		 * Mise en place du SplitPanel gauche/droite.
		 */
		splitPaneGaucheDroite.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPaneGaucheDroite.setDividerLocation(800);
		splitPaneGaucheDroite.setLeftComponent(leJardin);
		splitPaneGaucheDroite.setRightComponent(tree);

		/*
		 * Mise en place du textfield, des boutons plus/moins
		 * et de leurs actions permettant de mettre à jour le passage du temps.
		 */
		this.textfield = new JTextField();
		this.textfield.setText(String.valueOf(this.laPara.getTick()));
		this.textfield.setPreferredSize(new Dimension(50, 28));
		textfield.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int newValue = Integer.parseInt(textfield.getText());
				laPara.setTick(Integer.parseInt(textfield.getText()));
			}
		});

		this.boutonMoins = new JButton("-");
		boutonMoins.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int newValue = Integer.parseInt(textfield.getText()) - 10;
				textfield.setText(String.valueOf(newValue));
				laPara.setTick(newValue);
			}
		});

		this.boutonPlus = new JButton("+");
		boutonPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int newValue = Integer.parseInt(textfield.getText()) + 10;
				textfield.setText(String.valueOf(newValue));
				laPara.setTick(newValue);
			}
		});

		topPanel.add(boutonMoins);
		topPanel.add(textfield);
		topPanel.add(boutonPlus);

		pack();

		this.leJardin.setBackground(Color.WHITE);
		this.leJardin.setPreferredSize(new Dimension(800, 800));
	}

	/**
	 * Affichage de la fenetre.
	 */
	public void open() {
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(wa);
		setVisible(true);
	}

	/**
	 * Mise a jour de la position des Morph présents sur le World.
	 */
	private void miseAjourPos() {
		if (mesObjetsGraphiques.size() > 0) {

			ArrayList<IMovableDrawable> drawables = this.getLeJardin().contents();

			int i = 0;
			for (IMovableDrawable item : drawables) {
				int coordonneeX = (int) mesObjetsGraphiques.get(i).getrepresentationGraphique().getPosition().getX();
				int coordonneeY = (int) mesObjetsGraphiques.get(i).getrepresentationGraphique().getPosition().getY();

				IMovableDrawable unObjet = item;

				unObjet.setPosition(new Point(coordonneeX, coordonneeY));

				i++;
			}
		}
	}
	
	public World getWorld(){
		return leJardin;	
	}
	
	/**
	 * Ajoute une fourmi et au World pour pouvoir l'afficher par la suite
	 * @param objet : l'objet a ajouter
	 */
	public void ajouterFourmiAffichage(ObjetGraphique objet) {
		mesObjetsGraphiques.add(objet);
		int coordonneeX = (int) objet.getrepresentationGraphique().getPosition().getX();
		int coordonneeY = (int) objet.getrepresentationGraphique().getPosition().getY();
		this.getLeJardin().contents().add(objet.getrepresentationGraphique());
	}

	public Fourmiliere getLaFourmilieres() {
		return this.laFourmiliere;
	}

	public World getLeJardin() {
		return this.leJardin;
	}

	/**
	 * Met à jour le Morph d'un objet Graphique dans le World.
	 */
	public void updateEtreVivant(Morph old, Morph representationGraphique) {
		int index = this.leJardin.contents().indexOf(old);
		if (index > 0) {
			this.leJardin.contents().set(index, representationGraphique);
		}
	}

	/**
	 * Mise a jour horaire du Terrain. 
	 * Tous les objets se déplacent, et le World est rafraichit.
	 */
	@Override
	public void updateH() {

		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			for (ObjetGraphique unObjectGraphique : this.mesObjetsGraphiques) {
				unObjectGraphique.updateH();
			}

			this.miseAjourPos();
			this.getLeJardin().repaint();
		}
	}

	/**
	 * Mise a jour journaliere du Terrain. 
	 * Une proie est ajoutée aléatoirement sur le terrain, et le World est rafraichit.
	 */
	@Override
	public void updateJ() {
		for (ObjetGraphique unObjectGraphique : this.mesObjetsGraphiques) {
			unObjectGraphique.updateJ();
		}
		Araignee proie = new Araignee(1, (int) (15 + (Math.random() * 45)), this);
		this.ajouterFourmiAffichage(proie);
		this.miseAjourPos();

		this.getLeJardin().repaint();
	}

}
