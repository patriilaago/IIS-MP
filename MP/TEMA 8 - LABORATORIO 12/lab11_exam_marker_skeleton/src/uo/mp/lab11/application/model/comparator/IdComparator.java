package uo.mp.lab11.application.model.comparator;

import java.util.Comparator;

import uo.mp.lab11.application.model.StudentMark;

public class IdComparator implements Comparator<StudentMark>{

	@Override
	public int compare(StudentMark o1, StudentMark o2) {
		// TODO Auto-generated method stub
		return o1.getStudentId().compareTo(o2.getStudentId());
	}

}
