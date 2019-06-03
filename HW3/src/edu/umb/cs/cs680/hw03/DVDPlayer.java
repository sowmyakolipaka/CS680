package edu.umb.cs.cs680.hw03;

public class DVDPlayer {
	private DVDPlayer() {};
	private State state;
	private static DVDPlayer player = null;
	public void changeState(State state)
	{
		this.state = state;
	}
	public State getState()
	{
		return state;
	}
	public static DVDPlayer getInstance()
	{
		player = new DVDPlayer();
		return player;
	}
	public void openCloseButtonPushed()
	{
		state.openCloseButtonPushed(player);
	
	}
	public void stopButtonPushed()
	{
		state.stopButtonPushed(player);
	
	}
	public void playButtonPushed()
	{
		state.playButtonPushed(player);
	
	}
	
	public void open()
	{
		System.out.println("Open DVD");
	
	}
	public void close()
	{
		System.out.println("close DVD");
	
	}
	public void play()
	{
		System.out.println("play DVD");
	}
	public void stop()
	{
		System.out.println("stop DVD");
	}

}
