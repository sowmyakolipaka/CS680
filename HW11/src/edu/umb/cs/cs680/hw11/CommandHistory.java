package edu.umb.cs.cs680.hw11;

import java.util.LinkedList;

public class CommandHistory {
	
	private LinkedList<Command> history = null;
	
	public CommandHistory(){
		history = new LinkedList<> ();
	}
	
	public void push (Command c){
		history.add(c);
	}
	
	public Command pop(){
		
		return this.history.pop();
	}
	
	public LinkedList<Command> getHistory(){
		return this.history;
	}
	
	

}