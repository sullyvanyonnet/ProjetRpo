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
	private HashMap<Integer, IMovableDrawable> drawables = new HashMap<Integer, IMovableDrawable>();

	String name = "";
	
	public World(String name) {
		this.name = name;
	}
	public HashMap<Integer, IMovableDrawable> contents() {
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
	
     public void add(int cle, IMovableDrawable d) {
        drawables.put(cle, d);
     }
     
     public void remove(int cle) {
         drawables.remove(cle);
      }
     public void remove(IMovableDrawable d) {
        drawables.remove(d);
     }

    public void paint(Graphics g) {
        super.paint(g);
        Iterator iter = drawables.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            ((IDrawable) pair.getValue()).draw(g);
        }
    }

    public void clear() {
        drawables.clear();
     }

    public HashMap<Integer, IMovableDrawable> find(Point p) {
    	HashMap<Integer, IMovableDrawable> hm = new HashMap<Integer, IMovableDrawable>();
        
        Iterator iter = drawables.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            if (((IDrawable) pair.getValue()).getBounds().contains(p)) {
            	hm.put((Integer) pair.getKey(),(IMovableDrawable) pair.getValue());
            }
        }
        
        return hm;
    }


}