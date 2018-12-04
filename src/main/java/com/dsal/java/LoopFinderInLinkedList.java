package com.dsal.java;

public class LoopFinderInLinkedList {

	public static void main(String[] args) {

		LinkedNode root = null;
		root = LinkedListUtil.insert(root, 12);
		root = LinkedListUtil.insert(root, 90);
		root = LinkedListUtil.insert(root, 32);
		root = LinkedListUtil.insert(root, 67);
		root = LinkedListUtil.insert(root, 45);
		
		
		LinkedNode temp = new LinkedNode(80);
		temp.next = new LinkedNode(-90);
		temp.next.next = new LinkedNode(100);
		temp.next.next.next = new LinkedNode(-200);
		temp.next.next.next.next = new LinkedNode(70);
		
		// creating loop here at starting from 70 and ending at 100. i.e. 70 -> 100.
		temp.next.next.next.next.next = temp.next.next; 
		
		//LinkedListUtil.printList(temp);
//		System.out.println("linked list contains loop : " + LinkedListUtil.detectLoop(temp));
//		System.out.println("linked list contains loop : " + LinkedListUtil.detectLoop(root));
//		System.out.println("linked list contains loop : " + LinkedListUtil.hasCycle(temp));
		
		System.out.println("linked list contains loop : " + LinkedListUtil.detectCycle(temp));
		
		LinkedNode cyclePoint = LinkedListUtil.removeCycle(temp); 
		System.out.println("linked list contains loop : " + LinkedListUtil.detectCycle(temp));

		System.out.println("linked list contains loop at node with data: " + cyclePoint.data);


	}
}
