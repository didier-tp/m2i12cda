package com.mycompany.app3;

import java.util.ArrayList;
import java.util.List;

public class CalculatriceEx extends SimpleCalculatrice{
	private List<Double> serie;
	
	public CalculatriceEx() {
		serie = new ArrayList<>();
	}
	
	public void pushVal(double val) {
		serie.add(val);
	}
	
	public double sum() {
		double res=0;
		for(Double val : serie) {
			res+=val;
		}
		return res;
	}
	
	public double average() {
		double res=0;
		res=this.sum() / serie.size();
		return res;
	}
}
