package edu.umb.cs.cs680.hw01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import edu.umb.cs.cs680.hw01.Calculator;

public class CalculatorTest{
@Test
public void multiply3By4(){
Calculator cut = new Calculator();
float actual = cut.multiply(3,4);
float expected = 12;
assertThat(actual, is(expected)); }
@Test
public void divide3By2(){
Calculator cut = new Calculator();
float actual = cut.divide(3,2);
float expected = 1.5f;
assertThat(actual, is(expected)); }
@Test(expected=IllegalArgumentException.class)
public void divide5By0(){
Calculator cut = new Calculator();
cut.divide(5,0); }
@Test
public void multiply2_2BY5_5() {
Calculator cut = new Calculator();
float actual = cut.multiply(2.2f,5.5f);
float expected = 12.1f;
assertThat(actual, is(expected));
}
}
