package com.ibm.cbn.itademo.networking;

import java.io.Serializable;

public class Report implements Serializable {
	private static final long serialVersionUID = 1L;
	double bearing;
	double A[];
	double b[];
	public double getBearing() {
		return bearing;
	}
	public void setBearing(double bearing) {
		this.bearing = bearing;
	}
	public double[] getA() {
		return A;
	}
	public void setA(double[] a) {
		A = a;
	}
	public double[] getB() {
		return b;
	}
	public void setB(double[] b) {
		this.b = b;
	}
}
