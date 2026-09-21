package uo.mp.newsstand.comparator;

import java.util.Comparator;

import uo.mp.newsstand.domain.Order;

public class OrderComparator implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		// TODO Auto-generated method stub
		if(o1.getQuantity()-o2.getQuantity()!=0) {
			return o1.getQuantity()-o2.getQuantity();
		}
		else {
			return o1.getName().compareTo(o2.getName());
		}
	}

}
