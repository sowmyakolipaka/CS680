package edu.umb.cs.cs680.hw08;

public class DJIAEvent{

	private Float quote;
	private String ticker;

	public DJIAEvent(float quote, String ticker) {
		this.quote = quote;
		this.ticker = ticker;
	}


	public void setQuote(float quote) {
		this.quote = quote;
		
	}

	
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	
	public float getQuote() {
		return this.quote;
	}


	public String getTicker() {
		return this.ticker;
	}

}