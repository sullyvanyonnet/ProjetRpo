package test;

import java.util.concurrent.TimeUnit;

import Etape.*;
import modele.Coordonnees;

public class testText {

  public static void main(String[] args) throws InterruptedException {
    Adulte anthony = new Adulte();
    anthony.setCoordonnees(new Coordonnees(100, 100));
    System.out.println(anthony.toString());
    while (true) {
      anthony.seDeplacer();
      System.out.println(anthony.toString());
      TimeUnit.SECONDS.sleep(1);
    }
  }
}
