package ozly;
/**
 * @author ${geochirayath}
 
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class AthleteIDTest {

	@Test
	public void test() {
	
		Athlete a= new Athlete("Oz1101", "Alb",21, "ACT",'C', 0);
		a.setAthId("Oz1101");
		 assertEquals("Oz1101",a.getAthId());
			
	}
}
