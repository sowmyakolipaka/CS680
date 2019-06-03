package edu.umb.cs.cs680.hw01;
 

public class Calculator{
	
public float multiply(float x, float y){
return x * y;
}
public float divide(float x, float y){
if(y==0)
{ throw new IllegalArgumentException("division by zero");
}
return x/y;
}

public static void main(String[] args)
{
	Calculator cal = new Calculator ();
	cal.multiply(3,2);
}

}