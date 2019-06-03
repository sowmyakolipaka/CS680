package edu.umb.cs.cs680.hw08;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ObserverTest {


	private StockQuoteObservable stock;
	private float quote;
	
	
	@Before
	public void setUp(){
		
		
		PieChartObserver pieOb = new PieChartObserver();
		TableObserver tableOb = new TableObserver();
		ThreeDObserver threeDOb = new ThreeDObserver();
		quote = 200.80f;
		
		stock = new StockQuoteObservable();
		
		stock.addObserver(pieOb);
		stock.addObserver(tableOb);
		stock.addObserver(threeDOb);
		
	}
	
	@Test
	public void ChangeQuote() {
		stock.changeQuote(quote, "Audi Stock");
	}

	@Test
	public void ChangeQuoteStockEvent() {
		stock.changeQuote(new StockEvent("Audi Stock", quote));
	}
      
}
