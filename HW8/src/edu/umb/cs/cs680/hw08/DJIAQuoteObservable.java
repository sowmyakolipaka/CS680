package edu.umb.cs.cs680.hw08;

public class DJIAQuoteObservable extends Observable{
	
	public void changeQuote(String t, float f){
		this.setChanged();
		this.notifyObservers(event = new DJIAEvent(f, t));
	}

}