package com.github.asamolov.cci.p1.c3;

import org.junit.Test;
import org.junit.Before;
import java.util.Stack;
import java.util.Comparator;

import static org.junit.Assert.*;


/** 3.6 Write a program to sort a stack in ascending order 
 * You should not make any assumptions about how the stack is 
 * implemented The following are the only functions that should 
 * be used to write this program: push | pop | peek | isEmpty
 */
public class P1C3E6StackSorterTest {

	private P1C3E6StackSorter<String> sorter;

	@Before
	public void init() {
		sorter = new P1C3E6StackSorter<String>(new Comparator<String>() {
			public int compare(String a, String b) {
				if (a == null || b == null) throw new IllegalArgumentException("Cannot compare nulls!");

				return a.compareTo(b);
			}
		});
	}

	@Test
	public void trivialSort() {
		Stack<String> s = new Stack<String>();

		s.push("a");
		s.push("b");

		sorter.sort(s);

		assertEquals("a", s.pop());
		assertEquals("b", s.pop());
		assertTrue(s.empty());
	}

	@Test
	public void cornerCases() {
		Stack<String> s = new Stack<String>();

		// empty stack
		sorter.sort(s);

		// one element stack
		s.push("a");
		sorter.sort(s);

		assertEquals("a", s.pop());
		assertTrue(s.empty());
	}


	@Test
	public void arrangedData() {
		Stack<String> s = new Stack<String>();

		s.push("d");
		s.push("c");
		s.push("b");
		s.push("a");

		sorter.sort(s);

		assertEquals("a", s.pop());
		assertEquals("b", s.pop());
		assertEquals("c", s.pop());
		assertEquals("d", s.pop());
		assertTrue(s.empty());
	}


	@Test
	public void reverseData() {
		Stack<String> s = new Stack<String>();

		s.push("a");
		s.push("b");
		s.push("c");
		s.push("d");
		s.push("e");
		s.push("f");
		s.push("g");
		s.push("h");

		sorter.sort(s);

		assertEquals("a", s.pop());
		assertEquals("b", s.pop());
		assertEquals("c", s.pop());
		assertEquals("d", s.pop());
		assertEquals("e", s.pop());
		assertEquals("f", s.pop());
		assertEquals("g", s.pop());
		assertEquals("h", s.pop());
		assertTrue(s.empty());
	}
}