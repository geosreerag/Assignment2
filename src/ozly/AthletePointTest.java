package ozly;
/**
 * @author ${geochirayath}
 
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class AthletePointTest {

	@Test
	public void test() {

		Athlete a = new Athlete("Oz1101", "Alb", 21, "ACT", 'C', 0);
		a.setPoints(5);
		assertEquals(5, a.getPoints());

	}

}
