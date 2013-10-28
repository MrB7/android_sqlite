package com.collections.mrb7;

import java.util.LinkedList;
import java.util.ListIterator;

public class Listexample {

	public static void main(String[] args) {

		String forwards[] = { "Rooney ", "VanPersie ", "Chicharito " };
		LinkedList<String> list = new LinkedList<String>(); // ArrayList is
															// also  used or initialized and utilized in
															// similar way

		for (String x : forwards) {

			list.add(x); // This adds simple array in linkedlist or arraylist

		}

		for (String l : list) {

			System.out.print(l); // This arr stored in linkedlist collection and will print the dynamic list.
		}

		System.out.println(" ");

		String defenders[] = { "Vidic ", "Ferdinand ", "Rafael ","Evra " };
		LinkedList<String> list2 = new LinkedList<String>(); // This is another
																// List , just
																// ctrl+c and
																// ctrl+v

		for (String x : defenders) {

			list2.add(x);

		}

		for (String l : list2) {

			System.out.print(l);
		}

		System.out.println("");

		list.addAll(list2);
		// list2 = null;

		System.out.println(list);

		System.out.println("Man Utd's Forwards:- ");
		attackers(list);
		
		System.out.println("Man Utd's Defenders:- ");
		backFour(list);
		
		System.out.println("Man Utd's No.10:- ");
		FirstForward(list);
		
	}

	private static void FirstForward(LinkedList<String> list) {
		// TODO Auto-generated method stub
		
		String wazza = list.peekFirst();
		System.out.println(wazza);
		
		System.out.println(" ");
		
	}

	
	
	private static void backFour(LinkedList<String> list) {
		// TODO Auto-generated method stub
		
		ListIterator<String> four = list.listIterator(list.size());
		while(four.hasPrevious()){
			
			System.out.printf("%s",four.previous());
		}
		
		System.out.println("");
	
	}

	private static void attackers(LinkedList<String> list) {
	
		// TODO Auto-generated method stub
		
		System.out.println(list);
		
		System.out.println(" ");
	}

	
}
