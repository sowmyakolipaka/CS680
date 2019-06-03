package edu.umb.cs.cs680.hw05;

import java.awt.Point;
import java.util.ArrayList;

public class RectangleAreaCalc implements AreaCalculator{

	public float getArea(ArrayList<Point> points) {
		Point a  = points.get(0);
		Point b = points.get(1);
		Point c = points.get(2);
		Point d = points.get(3);
		
		double l = a.distance(b);
		double h = b.distance(c);
		
		float area = (float) (l * h) ;
		System.out.println("Area of Rectangle is :"+area);
		return area;
		
		
	}
	}
