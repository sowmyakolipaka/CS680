package edu.umb.cs.cs680.hw11;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement>{

	@Override
	public int compare(FSElement o1, FSElement o2) {
		// TODO Auto-generated method stub
		return o1.getCreated().compareTo(o2.getCreated());
	}

}
