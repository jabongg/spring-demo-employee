package com.dsal.java;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		Bean b1 = new Bean("abc");
		Bean b2 = new Bean("abc");
		
		String s1 = new String("jb");
		String s2 = new String("jb");
		
		Set<Bean> s = new HashSet<>();
		s.add(b1);
		s.add(b2);
		
		System.out.println(s.size() + " " + b1 + " " + b2);

	}

}
