package com.gynt.neuralfactory.core;

import java.nio.ByteBuffer;

import com.gynt.neuralfactory.core.functions.Function;

public class Synaps {

	private final Function weightfunction;
	private final double weight;
	private final Neuron from;
	private final Neuron to;
	private double value;
	
//	Synaps(Neuron to, Function weightfunction, double weight) {
//		this.from = null;
//		this.to = to;
//		this.weightfunction = weightfunction;
//		this.weight = weight;
//	}
//	
	Synaps(Neuron from, Neuron to, Function weightfunction, double weight) {
		this.from = from;
		this.to = to;
		this.weightfunction = weightfunction;
		this.weight = weight;
	}
	
	double compute(double in) {
		return weightfunction.compute(weight, in);
	}
	
	public Neuron getFrom() {
		return this.from;
	}
	
	public Neuron getTo() {
		return this.to;
	}

	double get() {
		return weightfunction.compute(weight, value);
	}

	void set(double d) {
		this.value = d;
	}
	
	byte[] serialize() {
		ByteBuffer b = ByteBuffer.allocate(4+4+8);
		b.putInt(from.id);
		b.putInt(to.id);
		b.putDouble(weight);
		return b.array();
	}
	
}
