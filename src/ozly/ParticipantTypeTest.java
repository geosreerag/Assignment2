package ozly;
/**
 * @author ${sreeragsaradesh}
 
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class ParticipantTypeTest {

	@Test
	public void test() {
	
		Athlete a= new Athlete("Oz1101", "Alb",21, "ACT",'C', 0);
		a.setType('C');
		 assertEquals('C',a.getType());
				
	}
}
