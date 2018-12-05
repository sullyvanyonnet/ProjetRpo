package testRole;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Etape.Adulte;
import Etape.Oeuf;
import Fourmi.Fourmi;
import Role.*;

class ReineTest {

	Fourmi mimi ;
	Adulte grandeMimi;
	
	@BeforeEach
	void setUp() throws Exception {
		mimi = new Fourmi(1);
		int ageMax = 40;
		boolean b = false;
		for (int i=0; i<ageMax; i++)
		{
			if("adulte".equals(mimi.isPhase()))
			{
				b = mimi.devenirReine();
				break;
			}
			mimi.vivre();
			TimeUnit.MILLISECONDS.sleep(1);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPondre() {
		assert((grandeMimi.getRole()).pondre() instanceof Oeuf);
	}

	@Test
	void testDureeVieFourmiReine() {
		double age = (grandeMimi.getRole()).dureeVieFourmiReine();		
		assert((age>=4*365)&&(age<=10*365));
	}

}
