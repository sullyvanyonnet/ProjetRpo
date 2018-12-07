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
import vue.IMovableDrawable;
import vue.Morph;
import vue.Oval;
import vue.World;

public class Terrain extends JFrame implements Observateur {

	/* les panneaux qui composent la fenetre */
	private JSplitPane splitPaneGaucheDroite; // s�paration haut bas pour la zone de texte
	private JSplitPane splitPaneHautBas; // s�paration gauche droite pour le world et l'arbre
	private JPanel topPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;

	/* les �l�ments du topPanel */
	private JTextField textfield;
	private JButton boutonMoins;
	private JButton boutonPlus;

	private World leJardin;
	private JTree tree;
	private Fourmiliere laFourmiliere;
	private Parametrage laPara;

	List<EtreVivant> mesObjetsGraphiques = new ArrayList<EtreVivant>();

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
	public World getWord(){
		return leJardin;	
	}
	private void ajouterFourmiAffichage(Fourmi unefourmi) {
		mesObjetsGraphiques.add(unefourmi);
		int coordonneeX = (int) unefourmi.getrepresentationGraphique().getPosition().getX();
		int coordonneeY = (int) unefourmi.getrepresentationGraphique().getPosition().getY();
		this.getLeJardin().contents().add(unefourmi.getrepresentationGraphique());
	}

	private void initFrame() {

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

		splitPaneHautBas.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPaneHautBas.setDividerLocation(100);
		splitPaneHautBas.setTopComponent(topPanel);
		splitPaneHautBas.setBottomComponent(splitPaneGaucheDroite);

		splitPaneGaucheDroite.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPaneGaucheDroite.setDividerLocation(800);
		splitPaneGaucheDroite.setLeftComponent(leJardin);
		splitPaneGaucheDroite.setRightComponent(tree);

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
		for (int i = 0; i < 20; i++) {
			laFourmiliere.updateH();

			this.miseAjourPos();
			this.getLeJardin().repaint();
		}
	}

	@Override
	public void updateJ() {
		laFourmiliere.updateJ();
		for (int i = 0; i < this.laFourmiliere.listeDeFourmis.size(); i++) {
			Fourmi unefourmi = laFourmiliere.getFourmis().get(i);
			
			ajouterFourmiAffichage(unefourmi);

		}
		this.miseAjourPos();

		this.getLeJardin().repaint();
	}

}
