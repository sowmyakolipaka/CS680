package edu.umb.cs.cs680.hw08;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class MulticastTest {
	
	PieChartObserver piechartObserver = null;
	TableObserver tableObserver = null;
	ThreeDObserver threeDObserver = null;
	
	StockQuoteObservable stockObservable = null;
	DJIAQuoteObservable djiaObservable = null;
	
	@Before
	public void setUp(){
	
		piechartObserver = new PieChartObserver();
		tableObserver = new TableObserver();
		threeDObserver = new ThreeDObserver ();
		
	}
	
	@After
	public void cleanUp(){
	
		piechartObserver = null;
		tableObserver = null;
		threeDObserver = null;
	}
	
	@Test
	public void StockEventObservableTest() {
		stockObservable = new StockQuoteObservable();
		
		stockObservable.addObservers(piechartObserver);
		stockObservable.addObservers(tableObserver);
		stockObservable.addObservers(threeDObserver);
		
		float [] quotes = {70f, 30f, 129.5f};
		String [] company = {"Walmart", "Target"};
		
		
			for (float f: quotes){
				for (String s: company){
					stockObservable.notifyObservers(new StockEvent (s, f));
				}
			}
		
		assertThat(stockObservable.getLastEvent().getQuote(), is(129.5f));
		
	}
	}