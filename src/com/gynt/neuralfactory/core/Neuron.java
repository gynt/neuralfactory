package com.gynt.neuralfactory.core;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.gynt.neuralfactory.core.functions.Function;

public class Neuron {

	private final Function function;
	private Collection<Synaps> in;
	private Collection<Synaps> out;
	int id;
	
	public Neuron(Function function) {
		this.function = function;
		this.in = new ArrayList<Synaps>();
		this.out = new ArrayList<Synaps>();
	}
	
	public Collection<Synaps> getAxons() {
		return this.in;
	}
	
	public Collection<Synaps> getDendrites() {
		return this.out;
	}
	
	public void propagate() {
		double[] inputs = new double[in.size()];
		int i = 0;
		Iterator<Synaps> iterator = in.iterator();
		while(iterator.hasNext()) {
			inputs[i]=iterator.next().get();
			i=i+1;
		}
		double ou = function.compute(inputs);
		for(Synaps o : this.out) {
			o.set(ou);
		}
	}
	
	public Synaps createDendrite(Function weightfunction, double weight) {
		Synaps result = new Synaps(null, this, weightfunction, weight);
		in.add(result);
		return result;
	}
	
	public Synaps createDendrite(Function weightfunction, double weight, Neuron from) {
		Synaps result = new Synaps(from, this, weightfunction, weight);
		in.add(result);
		from.out.add(result);
		return result;
	}
	
	public Synaps createAxon(Function weightfunction, double weight) {
		Synaps result = new Synaps(this, null, weightfunction, weight);
		out.add(result);
		return result;
	}
	
	public Synaps createAxon(Function weightfunction, double weight, Neuron to) {
		Synaps result = new Synaps(this, to, weightfunction, weight);
		out.add(result);
		to.in.add(result);
		return result;
	}
	
	byte[] serialize() {
		ByteBuffer b = ByteBuffer.allocate(4+4);
		b.putInt(id);
		b.putInt(function.id);
		return b.array();
	}
	
}
