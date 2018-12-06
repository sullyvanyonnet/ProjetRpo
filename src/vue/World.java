package vue;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel {
	private static final long serialVersionUID = 1L;
	private ArrayList<IMovableDrawable> drawables = new ArrayList<IMovableDrawable>();

	String name = "";

	public World(String name) {
		this.name = name;
	}

	public ArrayList<IMovableDrawable> contents() {
		return drawables;
	}

	public void open() {
		JFrame frame = new JFrame(name);
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		frame.addWindowListener(wa);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	public void add(IMovableDrawable d) {
		drawables.add(d);
	}

	public void remove(int cle) {
		drawables.remove(cle);
	}

	public void remove(IMovableDrawable d) {
		drawables.remove(d);
	}

	public void paint(Graphics g) {
        super.paint(g);
        
        for (IMovableDrawable item : drawables) {
            	item.draw(g);
    	}
        
    }

	public void clear() {
		drawables.clear();
	}

	public ArrayList<IMovableDrawable> find(Point p) {
		ArrayList<IMovableDrawable> l = new ArrayList<IMovableDrawable>();

		for (IMovableDrawable item : l) {
			if (item.getBounds().contains(p)) {
				l.add(item);
			}
		}

		return l;
	}

}