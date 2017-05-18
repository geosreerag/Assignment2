package ozly;

/**
 * @author ${sreeragsaradesh}
 
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AthleteIDTest.class, AthleteNameTest.class, AthletePointTest.class, AthleteStateTest.class,
		ParticipantTypeTest.class, SortingPerformanceTest.class })
public class AllJunitTestsSuite {

}
