package modele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import vue.Morph;
import vue.Oval;

public abstract class InterfaceMorph {
  
  static public Morph creeFourmi(Point pos) {
	  Dimension dim = new Dimension(3, 3);
	  return new Oval(Color.RED,pos,dim);
  }
  
  static public Morph creeFourmiliere(Point pos) {
		return new Oval(Color.BLACK, pos, new Dimension(20, 20));
  } 
  
}
