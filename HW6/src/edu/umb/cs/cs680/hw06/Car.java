package edu.umb.cs.cs680.hw06;

import java.util.ArrayList;
import java.util.Collections;

public class Car {
	private int Price;
	private int Year;
	private float Milage;
	private int DominationCount; 
	
   public Car(int Price, int Year, float Milage) {
	   this.Price = Price;
	   this.Year = Year;
	   this.Milage = Milage;
   }
   
   public int getPrice() {
	   return Price;
   }
   public int getYear() {
	   return Year;
   }
   public float getMilage() {
	   return Milage;
   }
   public void setDominationCount(int dominationCount) {
		// TODO Auto-generated method stub
		DominationCount = dominationCount;
	}
   public int getDominationCount() {
		return DominationCount; 
   }
   public static void main(String args[])
	{		
		ArrayList<Car> Cars = new ArrayList<Car>();
		
		Cars.add(new Car(40000,2018,10000));
		Cars.add(new Car(3000,2012,1050000));
		Cars.add(new Car(8000,2010,50000));
		Cars.add(new Car(2000,2017,30000));
		Cars.add(new Car(1500,2003,75000));
		Cars.add(new Car(1000,2017,6000));
		
		Collections.sort(Cars, new MilageComparator());
		for(Car c:Cars)
		{
			System.out.println("Sorted by Milage");
			System.out.println(c.getMilage()+",");
		}
		Collections.sort(Cars, new PriceComparator());
		for(Car c:Cars)
		{
			System.out.println("Sorted by Price");
			System.out.println(c.getPrice()+",");
		}
		
		Collections.sort(Cars, new YearComparator());
		for(Car c:Cars)
		{
			System.out.println("Sorted by year");
			System.out.println(c.getYear()+",");
		}
		Collections.sort(Cars, new DominationComparator(Cars));
		for(Car c:Cars)
		{
			System.out.println("Sorted by count");
			System.out.println(c.getDominationCount()+" , "+c.getPrice()+" , "+c.getYear()+" , "+c.getMilage());
		}
		}


		
	}


