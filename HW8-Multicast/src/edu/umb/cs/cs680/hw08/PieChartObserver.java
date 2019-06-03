package edu.umb.cs.cs680.hw08;


public class PieChartObserver implements StockQuoteObserver,DJIAQuoteObserver {
	
	public void updateStock(StockEvent event) {
		System.out.println(event.getTicker()+ "  "+ event.getQuote()+" \n");
	}
	public void updateDJIA(DJIAEvent event) {
		System.out.println("DJIA:" +event.getTicker() +" \n");
	}
}