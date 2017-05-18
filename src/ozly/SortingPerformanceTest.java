package ozly;
/**
 * @author ${geochirayath}
 
 */

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortingPerformanceTest {

	@Test(timeout = 100)
	public void array_sort_performance() {

		int array[] = { 124, 586, 457 };
		for (int i = 0; i < 1000000; i++) {
			array[0] = i;
			Arrays.sort(array);
		}

	}
}
