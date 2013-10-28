package com.collections.mrb7;

import java.util.Stack;

public class Stack_LIFO {

	public static void main(String[] args) {

		Stack<String> lifo = new Stack<String>();

		lifo.add("H");
		lifo.add("E");
		lifo.add("L");
		lifo.add("L");
		lifo.add("o");

		System.out.println(lifo);

		System.out.println("");

		System.out.println(lifo.peek());
		lifo.pop();

		System.out.println();

		System.out.println(lifo);

	}

}
