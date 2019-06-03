package edu.umb.cs.cs680.hw11;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement>{

	@Override
	public int compare(FSElement o1, FSElement o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
