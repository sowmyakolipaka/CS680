package edu.umb.cs.cs680.hw03;

public interface State {
	public void openCloseButtonPushed(DVDPlayer player);
	public void playButtonPushed(DVDPlayer player);
	public void stopButtonPushed(DVDPlayer player);
}
