package uo.mp.util.collections.impl;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ArrayList l = new ArrayList<>();
		l.add(1);
		l.add(2);
		
		for(Object o : l) {
			System.out.println(o);
		}
		
		Iterator iterator = l.iterator();
		while(iterator.hasNext()) {
			Object o = iterator.next();
			System.out.println(o);
		}
	}
}
