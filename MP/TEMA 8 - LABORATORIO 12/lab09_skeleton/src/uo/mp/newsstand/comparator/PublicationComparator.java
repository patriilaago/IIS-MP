package uo.mp.newsstand.comparator;

import java.util.Comparator;

import uo.mp.newsstand.domain.Publication;

public class PublicationComparator implements Comparator<Publication>{

	@Override
	public int compare(Publication o1, Publication o2) {
		// TODO Auto-generated method stub
		if(o1.getSales()-o2.getSales()!=0) {
			return o1.getSales()-o2.getSales();
		}
		else {
			if(o1.getStock()-o2.getStock()!=0) {
				return o1.getStock()-o2.getStock();
			}
			else {
				return o1.getName().compareTo(o2.getName());
			}
		}
	}
	
}
