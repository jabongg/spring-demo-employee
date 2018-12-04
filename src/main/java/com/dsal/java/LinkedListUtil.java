package com.dsal.java;

public class LinkedListUtil {

	public static LinkedNode insert(LinkedNode root, int data) {

		// if root is null
		// create a node
		if (root == null) {
			LinkedNode temp = new LinkedNode(data);
			root = temp;
			return root;
		} else {
			// add a node to the end of the list
			LinkedNode itr = root;
			while (itr.next != null) {
				itr = itr.next;
			}

			LinkedNode temp = new LinkedNode(data);
			itr.next = temp;
		}
		return root;
	}

	public static void printList(LinkedNode root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
	}

	// we can detect loop by having a boolean flag in every node.time complexity:
	// (O(n))
	// this will save us with hare and tortoise way
	public static boolean detectLoop(LinkedNode root) {
		LinkedNode itr = root;
		while (itr.next != null && itr.isTraversed == false) {
			itr.isTraversed = true;
			itr = itr.next;
		}

		if (itr.isTraversed == true && itr.next != null) {
			return true;
		}

		if (itr.next == null) {
			return false;
		}
		return false;
	}

	public static boolean hasCycle(LinkedNode head) {

		LinkedNode itr = head;
		while (itr.next != null && itr.data > 0) {
			itr.data = -(itr.data);
			itr = itr.next;
		}

		if (itr.data < 0) {
			return true;
		}

		if (itr.next == null) {
			return false;
		}
		return false;
	}
	
	// using Floyed's algorithm to detect cycle
	public static boolean detectCycle(LinkedNode root) {
		LinkedNode donkey = root;
		LinkedNode horse = root;
		
		while (donkey != null && horse != null && horse.next != null) {
			donkey = donkey.next;
			horse = horse.next.next;
			if (horse == donkey) {
				return true;
			}
		}
		return false;
	}
	
	// remove any loop/cycle from the loop
	public static LinkedNode removeCycle(LinkedNode root) {
		LinkedNode donkey = root;
		LinkedNode horse = root;
		
		while (donkey != null && horse != null && horse.next != null) {
			donkey = donkey.next;
			horse = horse.next;
			if (horse.next == donkey.next) {
				horse.next = null;
				return donkey.next;
			}
		}
		return root;
		
	}
}
