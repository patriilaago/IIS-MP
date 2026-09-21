package uo.mp.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.collections.List;

public class ArrayList implements List {

	private final static int INITIAL_CAPACITY = 20;
	
	private Object[] elements;
	private int numberOfElements;

	
	public ArrayList(int capacity) {
		this.elements= new Object[capacity];
		this.numberOfElements=0;
	}
	
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		ArgumentChecks.isTrue(o!=null, "The object cannot be null");
		for(int i = 0 ; i<elements.length ; i++) {
			if(elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(Object element) {
		// TODO Auto-generated method stub
		ArgumentChecks.isTrue(element!=null, "The object you want to add cannot be null");
		if (size() >= this.elements.length) {
			this.moreMemory();
		}
		this.elements[size()] = element;
		this.numberOfElements++;
		return true;
	}

	private void moreMemory() {
		Object[] aux = new Object[2 * elements.length];
		System.arraycopy(elements, 0, aux, 0,elements.length);
		elements = aux;
	}
	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(o==null && this.isEmpty()) {
			return false;
		}
		else {
			return false;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if(index<0 || index>=elements.length) {
			throw new IndexOutOfBoundsException("The index of the element you want to get is out of the limits");
		}
		return elements[index];
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		if(index<0 || index>=elements.length) {
			throw new IndexOutOfBoundsException("The index of the element you want to get is out of the limits");
		}
		ArgumentChecks.isTrue(element != null, "The element you want to set cannot be null");
		elements[index]=element;
		return element;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		ArgumentChecks.isTrue(element!=null, "The object you want to add cannot be null");
		if(index<0 || index>=elements.length) {
			throw new IndexOutOfBoundsException("The index of the element you want to add is out of the limits");
		}
		if (size() >= this.elements.length) {
			this.moreMemory(); }
			for(int i=size(); i>index; i--) {
			this.elements[i] = this.elements[i-1]; 
		}
			this.elements[index] = element;
			this.numberOfElements++;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
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
		return  new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator{

		private int current_index = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current_index < numberOfElements;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(!hasNext()) {
				throw new NoSuchElementException("");
			}
			Object next = elements[current_index];
			current_index++;
			return next;
		}
	}
}
