package com.gynt.neuralfactory.core;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Network {

	private Synaps[] inputs;
	private Neuron[][] layers;
	private Synaps output;

	public Network(Synaps[] inputs, Neuron[][] layers, Synaps output) {
		this.inputs = inputs;
		this.layers = layers;
		this.output = output;
	}
	
	public void setInputs(double... inputs) throws InputException {
		if(inputs.length<this.inputs.length) {
			throw new InputException("Given inputs does not satisfy inputs of network");
		}
		if(inputs.length>this.inputs.length) {
			throw new InputException("Too many given inputs for inputs of network");
		}
		for(int i = 0; i < inputs.length; i++) {
			this.inputs[0].set(inputs[i]);
		}
	}
	
	public void propagate() {
		for(int i = 0; i < layers.length; i++) {
			for(Neuron neuron : layers[i]) {
				neuron.propagate();
			}
		}
	}
	
	public double getOutput() {
		return output.get();
	}
	
}
