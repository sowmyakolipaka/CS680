package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;

public class History implements Command{

	private History() {};
	private ArrayList<Command> history = new ArrayList<Command>();
	private ArrayList<String> historyCommand = new ArrayList<String>();
	private static History instance = null;
	public static History getInstance() {
		if(instance == null) {
			instance = new History();
		}
		return instance;
	}
	
	public void add(Command command, String historyCommand) {
		this.history.add(command);
		this.historyCommand.add(historyCommand);
	}
	
	public Command lastExecuted() {
		if(history.size()>0) {
			return history.get(history.size()-1);
		}else {
			return null;
		}
	}
	
	public void execute() {
		
		for(String c: this.historyCommand) {
			System.out.println(c);
		}
		
	}

}
