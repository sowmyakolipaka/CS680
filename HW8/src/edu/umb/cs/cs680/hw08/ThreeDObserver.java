package edu.umb.cs.cs680.hw08;

public class ThreeDObserver implements Observer {
	
	private String ticker = null;
	private float quote = 0;

	@Override
	public void update(Observable o, Object arg) {
		
		if( arg instanceof StockEvent){
			ticker = ((StockEvent) arg).getTicker();
			quote = ((StockEvent) arg).getQuote();
			
		} else if ( arg instanceof DJIAEvent){
			ticker = ((DJIAEvent) arg).getTicker();
			quote = ((DJIAEvent) arg).getQuote();	
		}
		
		
		if (ticker !=null){
			print();
		}
	}
	
	private void print(){
		StringBuilder sb = new StringBuilder ();
		sb.append("3D Observer\n");
		sb.append("Name of the company - " + ticker + " | $ " + quote + "\n");
		System.out.print(sb);
		
	}

}