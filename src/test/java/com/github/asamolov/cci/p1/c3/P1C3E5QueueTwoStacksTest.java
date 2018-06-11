package com.github.asamolov.cci.p1.c3;

import org.junit.Test;

import static org.junit.Assert.*;

public class P1C3E5QueueTwoStacksTest {

	@Test
	public void noData() {
		P1C3E5QueueTwoStacks<String> q = new P1C3E5QueueTwoStacks<String>();

		// empty by default
		assertTrue(q.empty());

		q.enqueue("x");
		// non empty if in stack is filled
		assertFalse(q.empty());

		assertEquals("x", q.dequeue());
		assertTrue(q.empty());


		q.enqueue("x1");
		q.enqueue("x2");
		assertEquals("x1", q.dequeue());
		// non empty if out stack is filled
		assertFalse(q.empty());

		assertEquals("x2", q.dequeue());
		assertTrue(q.empty());
	}

	@Test
	public void mixedOps() {
		P1C3E5QueueTwoStacks<String> q = new P1C3E5QueueTwoStacks<String>();

		q.enqueue("x1");
		q.enqueue("x2");
		q.enqueue("x3");

		assertEquals("x1", q.dequeue()); // initial fill of out stack
		q.enqueue("y1");

		assertEquals("x2", q.dequeue()); // norefill of out stack, since some data sill there
		q.enqueue("y2");

		assertEquals("x3", q.dequeue()); // out stack is empty

		assertEquals("y1", q.dequeue()); // refill of out stack
		assertEquals("y2", q.dequeue()); // last element

		assertTrue(q.empty());
	}



	@Test
	public void nullStored() {
		P1C3E5QueueTwoStacks<String> q = new P1C3E5QueueTwoStacks<String>();

		q.enqueue(null);
		assertFalse(q.empty());

		assertNull(q.dequeue());
		assertTrue(q.empty());
	}

	@Test(expected=RuntimeException.class)
	public void emptyDequeue() {
		P1C3E5QueueTwoStacks<String> q = new P1C3E5QueueTwoStacks<String>();

		q.dequeue();
	}
}