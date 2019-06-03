package edu.umb.cs.cs680.hw05;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;


public class PTest{ 
@Test
		public void TriangleAreaTest() {
			ArrayList<Point> al = new ArrayList<Point>();
			al.add( new Point(0,0)); 
			al.add( new Point(6,0));
			al.add( new Point(6,2));
			
			Polygon p = new Polygon( al, new  TriangleAreaCalc() );
			float expected = p.getArea();
			float actual = 6;
			assertThat(actual, is(expected));
		}
	@Test
		public void TriangleaddtomakeRectangle() {
			ArrayList<Point> al = new ArrayList<Point>();
			al.add( new Point(0,0)); 
			al.add( new Point(6,0));
			al.add( new Point(6,2));
			
			Polygon p = new Polygon( al, new  TriangleAreaCalc() );
			p.addPoint(new Point(0,2));
			p.setAreaCalc(new RectangleAreaCalc());
			float expected = p.getArea();
			float actual = 12;
			assertThat(actual, is(expected));
		}
		@Test
		public void RectangleAreaTest() {
			ArrayList<Point> al = new ArrayList<Point>();
			al.add( new Point(0,0)); 
			al.add( new Point(5,0));
			al.add( new Point(5,3));
			al.add( new Point(0,3));
			Polygon p = new Polygon( al, new  RectangleAreaCalc() );
			float expected = p.getArea();
			float actual = 15;
			assertThat(actual, is(expected));
		}
		
	@Test
		public void RectangleArearemovetomakeTriangle() {
			ArrayList<Point> al = new ArrayList<Point>();
			al.add( new Point(0,0)); 
			al.add( new Point(5,0));
			al.add( new Point(5,3));
			al.add( new Point(0,3));
			Polygon p = new Polygon( al, new  RectangleAreaCalc() );
			p.removePoint(al.get(3));
			p.setAreaCalc(new TriangleAreaCalc());
			float expected = p.getArea();
			float actual = (float) 7.5;
			assertThat(actual, is(expected));
		}

}
