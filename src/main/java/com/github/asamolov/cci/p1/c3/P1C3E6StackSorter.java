package com.github.asamolov.cci.p1.c3;

import java.util.Stack;
import java.util.Comparator;

/** 3.6 Write a program to sort a stack in ascending order 
 * You should not make any assumptions about how the stack is 
 * implemented The following are the only functions that should 
 * be used to write this program: push | pop | peek | isEmpty
 */
public class P1C3E6StackSorter<T> {

	private final Comparator<T> c;

	public P1C3E6StackSorter(Comparator<T> c) {
		this.c = c;
	}

	public void sort(Stack<T> s) {
		if (s.empty()) {
			return;
		}
		while (!arrangeTop(s)) {}
	}

	// idea - we can arrange two top elements in the stack.
	// going recursive till the stack is not empty
	// each iteration stack is partially ordered, bigger elements going bottom
	// smaller elements - going up.
	// until order is established
	// this is very similar to bubble sort, thus complexity is O(N^2)
	// call stack serves as temporary storage

	// partially sorts the stack, returns true if stack is ordered.
	private boolean arrangeTop(Stack<T> s) {
		T t = s.pop();
		// single element remains - keep it there
		if (s.empty()) { 
			s.push(t); 
			return true;
		}
		// sub-stack is already arranged
		boolean ordered = arrangeTop(s);
		T top = s.peek();
		// if need to change order
		if (c.compare(t, top) > 0) {
			s.pop();
			s.push(t);
			s.push(top);
			// not ordered
			return false;
		} else {
			s.push(t);
			// ordered on current level
			return ordered;
		}
	}
}