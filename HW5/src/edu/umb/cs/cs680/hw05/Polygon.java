package edu.umb.cs.cs680.hw05;
import java.awt.Point;
import java.util.ArrayList;

public class Polygon {

	ArrayList< Point> points;
	AreaCalculator areaCalc;

	public Polygon(ArrayList<Point> points, AreaCalculator areaCalc) {
	
		this.points = points;
		this.areaCalc = areaCalc;
	}

	public void setAreaCalc(AreaCalculator calc) {	
		this.areaCalc=calc;
	}
	
	void addPoint(Point p) {
		points.add(p);
	}

	float getArea() {
		return areaCalc.getArea(points);
	}
	
	void removePoint(Point point) {
		points.remove(points);
	}
	
}
