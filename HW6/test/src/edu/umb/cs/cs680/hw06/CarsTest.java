package edu.umb.cs.cs680.hw06;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class CarsTest {

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
	}
	@Test
	
	public void PriceComparator()
	{
		
		int actual[] = {1000 , 1500 , 2000 , 3000 , 8000, 40000};
		int i=0;
		Collections.sort(Cars, new PriceComparator());
		System.out.println("\n");
		System.out.println("Price sorted:");
		for(Car c:Cars)
		{
			System.out.print(c.getPrice()+" , ");
			assertThat(actual[i],is(c.getPrice()));
			i++;
		}
				
	}
	
	@Test
	public void YearComparator()
	{
		
		int actual[] = {2018 , 2017 , 2017 , 2012 , 2010 , 2003};
		int i=0;
		Collections.sort(Cars, new YearComparator());
		System.out.println("\n");
		System.out.println("Year sorted:");
		for(Car c:Cars)
		{
			System.out.print(c.getYear()+" , ");
			assertThat(actual[i],is(c.getYear()));
			i++;
		}
				
	}
	@Test
	public void MilageComparator()
	{
		
		float actual[] = {6000, 10000 , 30000, 50000, 75000, 1050000};
		int i=0;
		Collections.sort(Cars, new MilageComparator());
		System.out.println("\n");
		System.out.println("Milage sorted:");
		for(Car c:Cars)
		{
			System.out.print(c.getMilage()+" , ");
			assertThat(actual[i],is(c.getMilage()));
			i++;
		}
				
	}
	
	@Test
	public void DominationComparator()
	{
		
		int actual[] = {0,0,1,1,2,2};
		int i=0;
		Collections.sort(Cars, new DominationComparator(Cars));
		System.out.println("\n");
		System.out.println("Domination Count :");
		for(Car c:Cars)
		{
			System.out.print(c.getDominationCount()+" , ");
			assertThat(actual[i],is(c.getDominationCount()));
			i++;
		}
				
	}
	
}
