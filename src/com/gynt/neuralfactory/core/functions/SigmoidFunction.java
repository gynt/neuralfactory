package com.gynt.neuralfactory.core.functions;

public class SigmoidFunction extends Function {

	SigmoidFunction(int id) {
		super(id);
	}
	
	@Override
	public double compute(double... inputs) {
		double x = 0.0;
		for(double input : inputs) {
			x+=input;
		}
		return 1.0/(1.0+Math.pow(Math.E, -1*x));
	}

}
