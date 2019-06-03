package edu.umb.cs.cs680.hw03;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class DrawerClosedPlayingTest {

	public static DVDPlayer p = null;
	@Before
	public void config()
	{
		p = DVDPlayer.getInstance();
		p.changeState(DrawerClosedPlaying.getInstance());
	}
	@Test
	public void playButtonPushed()
	{
		p.playButtonPushed();
		String expected = "DrawerClosedPlaying";
		String actual = p.getState().toString();
		assertThat (actual,is(expected));
	}
	
	@Test
	public void openCloseButtonPushedTest()
	{
		p.openCloseButtonPushed();
		String expected = "DrawerOpen";
		String actual = p.getState().toString();
		assertThat (actual,is(expected));
	}	
	@Test
	public void stopButtonPushed()
	{
		p.stopButtonPushed();
		String expected = "DrawerClosedNotPlaying";
		String actual = p.getState().toString();
		assertThat (actual,is(expected));
	}
}
