package edu.umb.cs.cs680.hw05;

import java.awt.Point;
import java.util.ArrayList;

public class TriangleAreaCalc implements AreaCalculator {
   
	public float getArea(ArrayList<Point> points) {
		Point a = points.get(0);
		Point b = points.get(1);
		Point c = points.get(2);
		
		double ab = a.distance(b);
		double bc = b.distance(c);
		double ca = c.distance(a);
		
		double s = (ab + bc + ca)/ 2 ;
		
		float area = (float) Math.sqrt(s*(s-ab)*(s-bc)*(s-ca));
		System.out.println("Area of Triangle is :"+area);
		return area;
		
	}
}
