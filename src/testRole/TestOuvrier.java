package testRole;

import java.awt.Point;
import java.util.ArrayList;

import Fourmi.Fourmi;
import Role.Ouvrier;

public class TestOuvrier {
	
	public static void main(String[] args) {
		ArrayList<Point> tabPoint = new ArrayList<Point>();
		Point unpoint = new Point(100,100);
		Fourmi unefourmi = new Fourmi(0, unpoint);
		Ouvrier unOuvrier = new Ouvrier(unefourmi);
		 tabPoint.add(unOuvrier.sedeplacer(unpoint));
		 tabPoint.add(unOuvrier.sedeplacer(tabPoint.get(tabPoint.size()-1)));
		 tabPoint.add(unOuvrier.sedeplacer(tabPoint.get(tabPoint.size()-1)));
		 
		 unOuvrier.rentre();
		 
		 if(tabPoint.get(tabPoint.size()-1).equals(unOuvrier.sedeplacer(tabPoint.get(tabPoint.size()-1)))) {
			 System.out.println("OK");
		 }
		 tabPoint.remove(tabPoint.size()-1);
		 if(tabPoint.get(tabPoint.size()-1).equals(unOuvrier.sedeplacer(tabPoint.get(tabPoint.size()-1)))) {
			 System.out.println("OK");
		 }
		 tabPoint.remove(tabPoint.size()-1);
		 if(tabPoint.get(tabPoint.size()-1).equals(unOuvrier.sedeplacer(tabPoint.get(tabPoint.size()-1)))) {
			 System.out.println("OK");
		 }
		
	}

}
