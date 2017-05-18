package ozly;
/**
 * @author ${sreeragsaradesh}
 
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class AthleteStateTest {

	@Test
	public void test() {

		Athlete a = new Athlete("Oz1101", "Alb", 21, "ACT", 'C', 0);
		a.setState("ACT");
		assertEquals("ACT", a.getState());

	}
}
