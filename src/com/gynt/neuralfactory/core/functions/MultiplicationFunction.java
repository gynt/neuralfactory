package com.gynt.neuralfactory.core.functions;

public class MultiplicationFunction extends Function {

	MultiplicationFunction(int id) {
		super(id);
	}
	
	@Override
	public double compute(double... inputs) {
		double x = 1.0;
		for(double input : inputs) {
			x*=input;
		}
		return x;
	}	
	
}
