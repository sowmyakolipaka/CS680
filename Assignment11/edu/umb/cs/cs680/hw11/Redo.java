package edu.umb.cs.cs680.hw11;

public class Redo implements Command{

	History history;
	
	public Redo(History history) {
		this.history = history;
	}
	
	public void execute() {
		Command last = history.lastExecuted();
		last.execute();
	}

}
