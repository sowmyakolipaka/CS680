
package edu.umb.cs.cs680.hw13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class CarTest {

	ArrayList<Car> Cars = new ArrayList<Car>();
	
	@Before
	public void AddingCars()
	{		
		Cars.add(new Car(40000,2018,10000));
		Cars.add(new Car(3000,2012,1050000));
		Cars.add(new Car(8000,2010,50000));
		Cars.add(new Car(2000,2017,30000));
		Cars.add(new Car(1500,2003,75000));
		Cars.add(new Car(1000,2017,6000));
		
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
	@Test
	public void priceComparator()
	{
		
		int actual[] = {1000 , 1500 , 2000 , 3000 , 8000, 40000};
		int i=0;
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getPrice()));
		System.out.println("\n");
		System.out.println("Price:");
		for(Car c:Cars)
		{
			System.out.print(c.getPrice()+" , ");
			assertThat(actual[i],is(c.getPrice()));
			i++;
		}
				
	}
	@Test
	public void priceComparatorReversed()	
	{
		int actual[] = {40000 , 8000 , 3000 , 2000 , 1500 , 1000};
		int i=0;
		Collections.sort(Cars, Comparator.comparing(Car::getPrice,
				Comparator.reverseOrder()));
		System.out.println("\n");
		System.out.println("Reversed Price:");
		for(Car c:Cars)
		{
			System.out.print(c.getPrice()+" , ");
			assertThat(actual[i],is(c.getPrice()));
			i++;
		}
				
	}
	
	@Test
	public void yearComparator()
	{
		
		int actual[] = {2003 , 2010 , 2012 , 2017 , 2017 , 2018};
		int i=0;
		Collections.sort(Cars,Comparator.comparing(
				(Car car)-> car.getYear()));
		System.out.println("\n");
		System.out.println("Year:");
		for(Car c:Cars)
		{
			System.out.print(c.getYear()+" , ");
			assertThat(actual[i],is(c.getYear()));
			i++;
		}
				
	}
	@Test
	public void yearComparatorReversed()
	{
		int actual[] = {2018 , 2017 , 2017 , 2012 , 2010 , 2003};
		int i=0;
		Collections.sort(Cars,Comparator.comparing(
				(Car car)-> car.getYear()).reversed());
		System.out.println("\n");
		System.out.println("Reversed Year:");
		for(Car c:Cars)
		{
			System.out.print(c.getYear()+" , ");
			assertThat(actual[i],is(c.getYear()));
			i++;
		}
				
	}
	@Test
	public void milageComparator()
	{
		
		float actual[] = {6000, 10000 , 30000, 50000, 75000, 1050000};
		int i=0;
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getMilage()));
		System.out.println("\n");
		System.out.println("Milage:");
		for(Car c:Cars)
		{
			System.out.print(c.getMilage()+" , ");
			assertThat(actual[i],is(c.getMilage()));
			i++;
		}
				
	}
	@Test
	public void milageComparatorReversed()
	{
		
		float actual[] = {1050000, 75000, 50000, 30000, 10000, 6000};
		int i=0;
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getMilage()).reversed());
		System.out.println("\n");
		System.out.println("Reversed Milage:");
		for(Car c:Cars)
		{
			System.out.print(c.getMilage()+" , ");
			assertThat(actual[i],is(c.getMilage()));
			i++;
		}
				
	}
	
	@Test
	public void DominationCount()
	{
		
		int actual[] = {0,0,1,1,2,2};
		int i=0;
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getDominationCount()));
		System.out.println("\n");
		System.out.println("Pareto:");
		for(Car c:Cars)
		{
			System.out.print(c.getDominationCount()+" , ");
			assertThat(actual[i],is(c.getDominationCount()));
			i++;
		}
				
	}
	@Test
	public void DominationCountReversed()
	{
		
		int actual[] = {2,2,1,1,0,0};
		int i=0;
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getDominationCount()).reversed());
		System.out.println("\n");
		System.out.println("Reversed Count:");
		for(Car c:Cars)
		{
			System.out.print(c.getDominationCount()+" , ");
			assertThat(actual[i],is(c.getDominationCount()));
			i++;
		}
				
	}

}
