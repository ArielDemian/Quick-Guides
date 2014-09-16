package org.demian.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {
	private Point center;

	public Point getCenter() {
		return center;
	}

	@Autowired
	public void setCenter(@Qualifier("circleRelated")Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("Drawing circle:");
		System.out.println("Circle center point is: (" + center.getX() + ", " + center.getY() + ")");
	}
}