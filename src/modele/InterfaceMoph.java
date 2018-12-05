package modele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import vue.Morph;
import vue.Oval;

public abstract class InterfaceMoph {
  
  static public Morph CreeFourmi(Point pos) {
	  Dimension dim = new Dimension(3, 3);
	  return new Oval(Color.RED,pos,dim);
  }
  
  static public Morph CreeFourmiliere(Point pos) {
		return new Oval(Color.BLACK, pos, new Dimension(20, 20));
  } 
  
}
