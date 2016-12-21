package com.gynt.neuralfactory.core.functions;

public class SumFunction extends Function {

	SumFunction(int id) {
		super(id);
	}
	
	@Override
	public double compute(double... inputs) {
		double x = 0.0;
		for(double input : inputs) {
			x+=input;
		}
		return x;
	}

	
	
}
