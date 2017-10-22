package testdevise;

import mockit.*;
import mockit.integration.junit4.JMockit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import devise.DeviseCalculator;
import devise.TauxChange;

@RunWith(JMockit.class)
public class DeviseCalculatorTestWithMockit {

	private DeviseCalculator deviseCalculator;

	@Mocked
	TauxChange tauxChange;


	@Test
	public void test() {
		new Expectations() {{
			tauxChange.getTaux(1.0, "euro", "dollard");
			result = 1.172;
		}};
		deviseCalculator = new DeviseCalculator(tauxChange);
		double value = deviseCalculator.euro2dollard(1.0);
		double expected = 1.172;
		assertTrue( value == expected);	
	}
	
	
	@Test
	public void test2() {
		new Expectations() {{
			tauxChange.getTaux(1.0, "euro", "dollard");
			result = 1.172;
		}};
		deviseCalculator = new DeviseCalculator(tauxChange);
		double value = deviseCalculator.euro2dollard(1.0);
		double expected = 1.172;
		assertTrue( value == expected);	
		new Verifications() {{
			tauxChange.getTaux(anyDouble , anyString, anyString);
			times = 1;
		}};

	}

}
