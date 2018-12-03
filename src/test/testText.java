package test;

import java.util.concurrent.TimeUnit;

import Etape.*;
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
    Adulte fourmule1 = newYork.ajouterFourmi();
    Adulte fourAPain = newYork.ajouterFourmi();
    
    while (true) {
      fourmule1.seDeplacer();
      System.out.println(fourmule1.toString());

      fourAPain.seDeplacer();
      System.out.println(fourAPain.toString());
      TimeUnit.SECONDS.sleep(1);
    }
    
  }
}
