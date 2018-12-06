package proie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestUnitaireProie {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	//constructeur Araignee	
	@Test
	void testNewAraigneeUnParametre() {
		Araignee aragne = new Araignee(1);
		assert(aragne instanceof Araignee);
	}
	
	//constructeur Araignee
	@Test
	void testNewAraigneeDeuxParametres() {
		Araignee aragne = new Araignee(1, 500);
		assert(aragne instanceof Araignee);
	}
	
	//constructeur Insecte
	@Test
	void testNewInsecteUnParametre() {
		Insecte cloporte = new Insecte(1);
		assert(cloporte instanceof Insecte);
	}
	
	//constructeur Insecte
	@Test
	void testNewInsecteDeuxParametres() {
		Insecte scolopandre = new Insecte(1, 500);
		assert(scolopandre instanceof Insecte);
	}
	
	//constructeur ProieLarve
	@Test
	void testNewProieLarveUnParametre() {
		ProieLarve larve = new ProieLarve(1);
		assert(larve instanceof ProieLarve);
	}
	
	//constructeur ProieLarve
	@Test
	void testNewProieLarveDeuxParametres() {
		ProieLarve larve = new ProieLarve(1, 500);
		assert(larve instanceof ProieLarve);
	}
	
	//TODO deplacement unitaire de la proie

}
