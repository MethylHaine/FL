package stringArray;

/**
 * This class is not documented
 * The specifications of the functions are not given
 * It seems related to arrays of Strings and elimination of
 * duplicate elements
 * @version unknown
 * @author web 
 */

/**
 * 3.2 Un code inconnu
 * 
 * @author MESTRALLET Alexis
 * @author RISCH Philippe
 * @version updated
 */

import java.util.*;

public class StringArray {
	private final String [] mlist;

	public StringArray(String[] list){
		int dupl = 0;
		if (list.length > 0) {
			String last = list[0];
			int index = 0;
			while (++index < list.length){
				String comp = list[index];
				int diff = last.compareTo(comp);
				if (diff > 0){
					Arrays.sort(list);
					index = 0 ;
					last = list[index];
				} else if (diff < 0) {
					last = comp;
				} else {
					dupl++;
				}
			}	
		}
		if(dupl > 0) {
			String [] uniques = new String[list.length - dupl];
			String last = list[0];
			int index = 0;
			int fill = -1;
			while (++index < list.length) {
				if(!last.equals(list[index])) {
					uniques[++fill] = last;
					last = list[index];
				}
			}
			uniques[uniques.length-1] = list[list.length-1] ;
			mlist = uniques;
		} else {
			mlist = list;		
		}
	}

	public String getString(int index){
		return mlist[index];
	}

	public int IndexOf( String value){
		int base = 0;
		int limit = mlist.length -1;
		while (base <= limit){
			int cur = (base + limit) >> 1;
		int diff = value.compareTo(mlist[cur]);
		if (diff < 0){
			limit = cur - 1;
		} else if (diff > 0) {
			base = cur + 1;
		} else {
			return cur;
		}
		}
		return -1;
	}

	public int sizeOf(){
		return mlist.length;
	}

	/* il sera utile de commenter ou supprimer  le programme principal
	 * lors des calculs de couverture.
	 * Il ne ser qu'a montrer le fonctionnement du constructeur
	 */
	/*public static void  main(String [] args) {
		String [] l = {"c", "b", "a"} ;
		StringArray a = new StringArray(l);
		int n = a.sizeOf();
		for (int i = 0; i < n ; i++) {
			System.out.print(a.getString(i));
		}
	}
	*/
}
