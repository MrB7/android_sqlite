package com.collections.mrb7;

import java.util.PriorityQueue;

public class Queue {

	
	
	public static void main(String[] args) {
		
		PriorityQueue<String> line = new PriorityQueue<String>();
		
		line.add("a");
		line.add("b");
		line.add("c");
		
		System.out.println(line);
		
		System.out.println(line.peek());
		line.poll();
		
		System.out.println(line);
		
	}
	
	
}
