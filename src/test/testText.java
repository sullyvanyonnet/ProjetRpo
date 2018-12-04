package test;

import java.util.concurrent.TimeUnit;

import Etape.*;
import Fourmi.Fourmi;
import modele.Coordonnees;
import modele.Fourmiliere;

public class testText {

	public static void main(String[] args) throws InterruptedException {
		testFourmiliere();
		//testGrosseFourmiliere();
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

	public static void testFourmiliere() throws InterruptedException {
		Fourmiliere newYork = new Fourmiliere();
		Fourmi fourmule1 = newYork.ajouterFourmi();
		fourmule1.evolutionAdulte();
		Fourmi fourmAPain = newYork.ajouterFourmi();
		fourmAPain.evolutionAdulte();

		Adulte adulte1 = fourmule1.isAdult();
		adulte1.setCoordonnees(new Coordonnees(100, 100));
		Adulte adulteAir = fourmAPain.isAdult();
		adulteAir.setCoordonnees(new Coordonnees(100, 100));

		while (true) {
			if (adulte1 != null) {
				adulte1.seDeplacer();
				System.out.println("Fourmule1  : " + adulte1.toString());
			}
			TimeUnit.MILLISECONDS.sleep(400);

			if (adulteAir != null) {
				adulteAir.seDeplacer();
				System.out.println("FourmAPain : " + adulteAir.toString());
			}
			TimeUnit.MILLISECONDS.sleep(400);
		}

	}

	public static void testGrosseFourmiliere() throws InterruptedException {
		Fourmiliere newYork = new Fourmiliere();
		Fourmi[] tabFourmis = new Fourmi[100];
		Adulte[] tabAdultes = new Adulte[100];
		for (int i = 0; i < 100; i++) {
			tabFourmis[i] = newYork.ajouterFourmi();
			tabFourmis[i].evolutionAdulte();
			tabAdultes[i] = tabFourmis[i].isAdult();
			tabAdultes[i].setCoordonnees(new Coordonnees(100, 100));
		}

		while (true) {
			for (int i = 0; i < 100; i++) {
				tabAdultes[i].seDeplacer();
				System.out.println("Fourmi " + i + " : " + tabAdultes[i].toString());
			}
			TimeUnit.MILLISECONDS.sleep(100);
			System.out.println();
		}

	}
}
