package uo.mp.lab11.application.model.comparator;

import java.util.Comparator;

import uo.mp.lab11.application.model.StudentMark;

public class MarkComparator implements Comparator<StudentMark>{

	@Override
	public int compare(StudentMark o1, StudentMark o2) {
		// TODO Auto-generated method stub
		if(o1.getMark()-o2.getMark()!=0) {
			if(o1.getMark()>o2.getMark()) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else {
			return o1.getStudentId().compareTo(o2.getStudentId());
		}
	}


}
