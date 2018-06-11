package com.github.asamolov.cci.p1.c3;

import java.util.Stack;

// 3.5 Implement a MyQueue class which implements a queue using two stacks
public class P1C3E5QueueTwoStacks<T> {

	// stack is LIFO, queue is FIFO, items are reversed via second stack
	private Stack<T> in = new Stack<T>();
	private Stack<T> out = new Stack<T>();	

	// enqueue to the IN stack
	public void enqueue(T item) {
		in.push(item);
	}

	// dequeue from OUT stack. If empty - move data from IN -> OUT.
	public T dequeue() {
		if (empty()) { throw new RuntimeException("queue is empty!"); }
		if (out.empty()) {
			// moving from in stack to out stack in FIFO order
			while (!in.empty()) {
				out.push(in.pop());
			}
		}
		return out.pop();
	}

	public boolean empty() {
		return in.empty() && out.empty();
	}
}