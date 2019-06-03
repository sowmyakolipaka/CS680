package edu.umb.cs.cs680.hw08;

public interface StockQuoteObserver {
	public void updateStock(StockEvent event);

	void updateDJIA(DJIAEvent e);
}