package com.collections.mrb7;

import java.util.ArrayList;
import java.util.HashSet;

public class Hash_Set {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String managers[] = {"ferguson ","Mourinho ","Moyes ","Moyes "};
		
		ArrayList<String> list 	 = new ArrayList<String>();
		
		for (String x : managers) {
			
			list.add(x);
		}
		
		
	
			System.out.print(list);
		
		
			System.out.println("");
			
			HashSet<String> sortedlist = new HashSet<String>();
			
			for(String s:managers){
				sortedlist.add(s);
			}
			
			System.out.print(sortedlist);
		
	}

}
