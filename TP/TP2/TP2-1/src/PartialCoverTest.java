package partialCovering;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 3.1 Un code simple
 * 
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 * @version updated
 */
public class PartialCoverTest {

	@Test
	public void testZeroOrOneXLower(){
		int x = 0;
		int y = 1;
		int expected = 0; 
		int val = PartialCover.returnZeroOrOne(x, y);
		assertEquals(expected, val, 0);
	
	}
	
	@Test
	public void testZeroOrOneEquality() {
		int x = 0;
		int y = 0;
		int expected = 0; 
		int val = PartialCover.returnZeroOrOne(x, y);
		assertEquals(expected, val, 0);
	
	}
	
	@Test
	public void testZeroOrOneXSup() {
		int x = 0;
		int y = 1;
		int expected = 0; 
		int val = PartialCover.returnZeroOrOne(x, y);
		assertEquals(expected, val, 0);
	
	}

}
