package uo.mp.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.collections.List;

public class LinkedList implements List {

	private static class Node {
		Object value;
		Node next;
		
		Node(Object value, Node next) {
		this.value = value;
		this.next = next;
		}
	}
	
	private Node head;
	private int numberOfElements;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size() == 0;

	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	private void addFirst(Object element) {
		// TODO Auto-generated method stub
		this.head = new Node(element,null);
	}
	
	@Override
	public void add(int index,Object element) {
		// TODO Auto-generated method stub
		ArgumentChecks.isTrue(element!=null, "The object you want to add cannot be null");
		if(index<0 || index>=size()) {
			throw new IndexOutOfBoundsException("The index of the element you want to add is out of the limits");
		}
		if (index==0)
			addFirst(element);
		else {
			Node previous = getNode(index-1);
			previous.next = new Node(element, previous.next);
			this.numberOfElements++;
		}
	}
	
	@Override
	public boolean add(Object element) {
		// TODO Auto-generated method stub
		ArgumentChecks.isTrue(element!=null, "The object you want to add cannot be null");
		if (this.isEmpty()) {
			addFirst(element);
			return true;
		}
		else {	
			Node last = getNode(size()-1);
			last.next = new Node(element, null);
			this.numberOfElements++;
			return true;
		}
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return getNode(index).value;
	}
	
	private Node getNode(int index) {
		int position = 0;
		Node node = this.head;
		while (position < index) {
			node = node.next;
			position++; 
		}
		return node;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		if(index<0) {
			throw new IndexOutOfBoundsException("The index of the element you want to get is out of the limits");
		}
		ArgumentChecks.isTrue(element != null, "The element you want to set cannot be null");
		getNode(index).value = element;
		return element;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}
		if(index<0) {
			throw new IndexOutOfBoundsException("The index of the element you want to get is out of the limits");
		}
		Object value;
		if (index == 0) { 
			value = this.head.value;
			this.head = this.head.next;
		} 
		else {
			Node previous = getNode(index - 1);
			value = previous.next.value;
			previous.next = previous.next.next;
		}
		this.numberOfElements--;
		return value;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		if(o == null || this.isEmpty()) {
			return -1;
		}
		return 0;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator{

		private Node current = head;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(!hasNext()) {
				throw new NoSuchElementException("");
			}
			Object nodeToReturn = current.value;
			current = current.next;
			return nodeToReturn;
		}
	}
}
