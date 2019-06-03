package edu.umb.cs.cs680.hw13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
			
		
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getMilage()));		
		System.out.println("Milage:");
		for(Car c:Cars)
		{
			System.out.print(c.getMilage()+" , ");
		}
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getMilage()).reversed());		
		System.out.println("Reversed Order Milage:");
		for(Car c:Cars)
		{
			System.out.print(c.getMilage()+" , ");
		}

		Collections.sort(Cars,Comparator.comparing(
				(Car car)-> car.getPrice()));
		System.out.println("Price:");
		for(Car c:Cars)
		{
			System.out.print(c.getPrice()+" , ");
		}
		
		Collections.sort(Cars,Comparator.comparing(Car::getPrice,
				Comparator.reverseOrder()));
		System.out.println("Reversed Order Price:");
		for(Car c:Cars)
		{
			System.out.print(c.getPrice()+" , ");
		}
	
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getYear()));

		System.out.println("Year:" );
		for(Car c:Cars)
		{
			System.out.print(c.getYear()+" , ");
		}
		
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getYear()).reversed());
		
		System.out.println("Reversed Order Year:" );
		for(Car c:Cars)
		{
			System.out.print(c.getYear()+" , ");
		}
		
		
		Collections.sort(Cars, Comparator.comparing(
		(Car car)-> car.getDominationCount()));
		System.out.println("Domination Count :");
		for(Car c:Cars)
		{
			System.out.println(c.getDominationCount()+" , "+c.getPrice()+" , "+c.getYear()+" , "+c.getMilage());
		}	
		
		Collections.sort(Cars, Comparator.comparing(
				(Car car)-> car.getDominationCount()).reversed());
		System.out.println("Reversed Count :" );
		for(Car c:Cars)
		{
			System.out.println(c.getDominationCount()+" , "+c.getPrice()+" , "+c.getYear()+" , "+c.getMilage());
		}	
		
	}
	
}
