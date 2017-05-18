package ozly;
/**
 * @author ${sreeragsaradesh}
 
 */
import static org.junit.Assert.*;

import org.junit.Test;

import ozly.Athlete;

public class AthleteNameTest {

	@Test
	public void test() {

		Athlete a = new Athlete("Oz1101", "Alb", 21, "ACT", 'C', 0);
		a.setName("Alb");
		assertEquals("Alb", a.getName());

	}

}
