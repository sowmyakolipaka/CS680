package edu.umb.cs.cs680.hw03;

public class DrawerClosedPlaying implements State  
	{	
		private static DrawerClosedPlaying instance = null ;
		private DrawerClosedPlaying()
		{};
		public static DrawerClosedPlaying getInstance()
		{
			if (instance == null)
				instance = new DrawerClosedPlaying();
			return instance;
		}
public void openCloseButtonPushed(DVDPlayer player)
		{
			player.stop();
			player.open();
			player.changeState(DrawerOpen.getInstance());
		}
		public void stopButtonPushed(DVDPlayer player)
		{
		player.stop();
		player.changeState(DrawerClosedNotPlaying.getInstance());
		}
		public void playButtonPushed(DVDPlayer player)
		{}
		
		public String toString()
		{
			return "DrawerClosedPlaying";
			
		}
	}
