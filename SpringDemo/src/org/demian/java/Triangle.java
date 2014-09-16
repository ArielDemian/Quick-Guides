package org.demian.java;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

public class Triangle implements InitializingBean, DisposableBean, Shape {
	private Point pointA, pointB, pointC;

	public void draw() {
		System.out.println("Drawing triangle:");
		System.out.println("Point A: (" + pointA.getX() + ", " + pointA.getY() + ")");
		System.out.println("Point B: (" + pointB.getX() + ", " + pointB.getY() + ")");
		System.out.println("Point C: (" + pointC.getX() + ", " + pointC.getY() + ")");
	}

	public Point getPointA() {
		return pointA;
	}

	@Required
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	@Required
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	@Required
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing bean. Init method called for triangle.");
	}

	public void destroy() throws Exception {
		System.out.println("Destroying bean \"triangle\".");
	}

	public void myIinit() {
		System.out.println("My init method called for triangle!");
	}
}