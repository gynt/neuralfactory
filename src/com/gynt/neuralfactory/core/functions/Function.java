package com.gynt.neuralfactory.core.functions;

import java.util.Iterator;

public abstract class Function {
	
	public static class IdProvider {
		private static int id = 0;
		public static final int next() {
			id = id + 1;
			return id;
		}
	}

	public final int id;
	
	public Function(int id) {
		this.id = id;
	}
	
	public abstract double compute(double... inputs);
	
	public static final Function SUM_FUNCTION = new SumFunction(IdProvider.next());
	public static final Function MULTIPLY_FUNCTION = new MultiplicationFunction(IdProvider.next());
	public static final Function WEIGHT_FUNCTION = MULTIPLY_FUNCTION;
	public static final Function SIGMOID = new SigmoidFunction(IdProvider.next());

}
