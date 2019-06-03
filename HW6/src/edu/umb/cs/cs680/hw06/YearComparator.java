package edu.umb.cs.cs680.hw06;

import java.util.Comparator;

public class YearComparator implements Comparator<Car>
{
	@Override
	public int compare(Car car1, Car car2) 
	{
			return car2.getYear() - car1.getYear();
	}
}