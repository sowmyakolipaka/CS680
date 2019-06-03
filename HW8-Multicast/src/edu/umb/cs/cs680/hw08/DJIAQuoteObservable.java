package edu.umb.cs.cs680.hw08;

import java.util.ArrayList;

public class DJIAQuoteObservable {

	private ArrayList<DJIAQuoteObserver>  collection;
	
	public DJIAQuoteObservable() {
		collection = new ArrayList<DJIAQuoteObserver> ();
	}
	
	
	public void addObservers(PieChartObserver piechartObserver) {
		
		if (this.collection == null){
			this.collection = new ArrayList<DJIAQuoteObserver> ();
		}
		
		this.collection.add((DJIAQuoteObserver) piechartObserver);
		
		System.out.println("Collection is here");
		
	}
	public void notifyObservers(DJIAEvent arg) {
		
			for (int i = 0; i < collection.size(); i++)
			{ 
				System.out.println("\n");
				collection.get(i).updateDJIA(arg);
		     }  
		
		
	}
}