package edu.umb.cs.cs680.hw08;

import java.util.ArrayList;

public class Observable {
	
	ArrayList<Observer> observers;
	private boolean changed = false;
	protected Event event = null;
	
	public Observable() {
		observers = new ArrayList<>();
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void setChanged() {
		changed = true;
	}
	public boolean hasChanged() {
		return changed;
	}
	public void  clearChanged() {
		changed = false;
	}
	public void notifyObservers() {
		notifyObservers(null);
		
	}
	public void notifyObservers(Object arg) {
		
		if (this.hasChanged() == true) {
			for (Observer obsr: observers) {
				obsr.update(this, arg);
			}
			clearChanged();
		}
	}

	}
