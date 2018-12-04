package test;

import java.util.concurrent.TimeUnit;

import Etape.*;
import Fourmi.Fourmi;
import modele.Coordonnees;
import modele.Fourmiliere;

public class testText {

  public static void main(String[] args) throws InterruptedException {
    testFourmiSolo();
  }
  
  public static void testFourmiSolo() throws InterruptedException {
    Adulte anthony = new Adulte();
    anthony.setCoordonnees(new Coordonnees(100, 100));
    System.out.println(anthony.toString());
    while (true) {
      anthony.seDeplacer();
      System.out.println(anthony.toString());
      TimeUnit.SECONDS.sleep(1);
    }
  }
  
  public void testFourmiliere() throws InterruptedException {
    Fourmiliere newYork = new Fourmiliere();
    Fourmi fourmule1 = newYork.ajouterFourmi();
    fourmule1.evolutionAdulte();
    Fourmi fourmAPain = newYork.ajouterFourmi();
    fourmAPain.evolutionAdulte();
    
    
    while (true) {
      Adulte adulte1;
      if ( (adulte1 = fourmule1.isAdult()) != null) {
        adulte1.seDeplacer();
      }
      System.out.println("Fourmule1 : " + adulte1.toString());

      Adulte adulteAir;
      if ( (adulteAir = fourmAPain.isAdult()) != null) {
        adulteAir.seDeplacer();
      }
      System.out.println("FourmAPain : " + adulteAir.toString());
      TimeUnit.SECONDS.sleep(1);
    }
    
  }
}
