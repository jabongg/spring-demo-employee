package com.dsal.java;

public class LinkedNode {

	LinkedNode next;
	int data;
	Boolean isTraversed;

	public LinkedNode(int data) {
		super();
		this.next = null;
		this.data = data;
		this.isTraversed = false;
	}
}
