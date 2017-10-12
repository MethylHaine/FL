package testStringArray;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import stringarray.StringArray;

public class StringArrayTest1 {

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
		public void testStringArray() {
			array1=new StringArray(slist1);
			array2=new StringArray(slist2);	
			assertEquals(8,array1.sizeOf());		
			assertEquals(7,array2.sizeOf());	
		}

		@Test
		public void test1IndexOf() {
			array2=new StringArray(slist2);
			assertEquals(-1,array2.IndexOf("ee"));
		}
		
		@Test
		public void test2IndexOf() {
			array2=new StringArray(slist2);
			assertEquals(3,array2.IndexOf("d"));
		}
		
}
