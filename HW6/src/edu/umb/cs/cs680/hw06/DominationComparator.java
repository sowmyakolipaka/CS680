package edu.umb.cs.cs680.hw06;

import java.util.ArrayList;
import java.util.Comparator;

public class DominationComparator implements Comparator<Car>{

	public DominationComparator(ArrayList<Car> Cars) {
		// TODO Auto-generated constructor stub
		for(Car c:Cars) {
			int dominationCount=0;
		for(Car car:Cars) {
			if(c.getMilage() > car.getMilage() && c.getPrice() > car.getPrice() && c.getYear() < car.getYear()) {
				dominationCount++;
			}else if((c.getMilage() > car.getMilage() || c.getYear() < car.getYear()) && c.getPrice() == car.getPrice()) {
				dominationCount++;
			}else if((c.getMilage() > car.getMilage() || c.getPrice() > car.getPrice()) && c.getYear() == car.getYear()) {
				dominationCount++;
			} else if(c.getMilage() == car.getMilage() && c.getPrice() == car.getPrice() && c.getYear() == car.getYear()) {
				//Nothing
			}else if(c.getMilage() == car.getMilage() && (c.getPrice() > car.getPrice() || c.getYear() < car.getYear())) {
				dominationCount++;
			}
			
		}
		
		c.setDominationCount(dominationCount);
	}
}

@Override
public int compare(Car car1, Car car2) 
{
	return car1.getDominationCount() - car2.getDominationCount();
	}

}
