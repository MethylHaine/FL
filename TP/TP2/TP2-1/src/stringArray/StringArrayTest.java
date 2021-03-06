package stringArray;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import stringArray.StringArray;

/**
 * 
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 *
 */
public class StringArrayTest {

		private static String[] slist1={
			"a","b","ccc","ccd","d","e","f","g"
		};
		private static String[] slist2={
			"ab","ccd","ccc","g","f","e","d"
		};

		private StringArray array1;
		private StringArray array2;
		

		@Before
		public void setUp() throws Exception {		
	        System.out.println("debut du test");
		}
		@After
		public void tearDown() {
			System.out.println("fini");
		}
		
		@Test
		public void testStringArraySingleDuplication() {
			String[] duplicate = {"ab", "ab"} ;
			String[] expected = {"ab"} ;
			array1 = new StringArray(duplicate);
			for(int i=0 ; i<array1.sizeOf() ; i++) {
				assertEquals(expected[i], array1.getString(i));
			}
		}
		
		@Test
		public void testStringArrayMultiDuplication() {
			String[] duplicate = {"ab", "c", "ab", "d", "ee", "ee"} ;
			String[] expected = {"ab", "c", "d", "ee"} ;
			array1 = new StringArray(duplicate);
			for(int i=0 ; i<array1.sizeOf() ; i++) {
				assertEquals(expected[i], array1.getString(i));
			}
		}

		@Test
		public void testStringArrayListEmpty() {
			String[] duplicate = new String[0] ;
			array1 = new StringArray(duplicate);
			assertEquals(0, array1.sizeOf());;
		}
		
		@Test
		public void testStringArray() {
			array1 = new StringArray(slist1);
			array2 = new StringArray(slist2);	
			assertEquals(8,array1.sizeOf());		
			assertEquals(7,array2.sizeOf());	
		}

		@Test
		public void testIndexOfeeOccurence() {
			array2=new StringArray(slist2);
			assertEquals(-1,array2.IndexOf("ee"));
		}
		
		@Test
		public void testIndexOfdOccurence() {
			array2=new StringArray(slist2);
			assertEquals(3,array2.IndexOf("d"));
		}
		
		@Test
		public void testGetString() {
			array2=new StringArray(slist2);
			assertEquals("ab", array2.getString(0));
		}
		
		//Only for sorted arrays
		@Test
		public void testIndexElementEqualsForArraySort() {
			array1 = new StringArray(slist1) ;
			for(int i=0 ; i<slist1.length ; i++) {
				assertEquals(i, array1.IndexOf(slist1[i]));
			}
		}
		
}
