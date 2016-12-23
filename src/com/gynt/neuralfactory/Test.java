package com.gynt.neuralfactory;

import com.gynt.neuralfactory.core.Network;
import com.gynt.neuralfactory.core.Neuron;
import com.gynt.neuralfactory.core.Synaps;
import com.gynt.neuralfactory.core.functions.Function;
import com.gynt.neuralfactory.core.functions.SigmoidFunction;

public class Test {

	public static void main(String[] args) {

		
		
		Neuron layer1 = new Neuron(Function.SIGMOID);
		
		Synaps input1 = layer1.createDendrite(Function.WEIGHT_FUNCTION, 1.0);
		Synaps input2 = layer1.createDendrite(Function.WEIGHT_FUNCTION, 1.0);
		
		Neuron output = new Neuron(Function.SIGMOID);
		
		Synaps mid = output.createDendrite(Function.WEIGHT_FUNCTION, 1.0, layer1);
		
		Synaps out = output.createAxon(Function.WEIGHT_FUNCTION, 1.0);
		
		Network n = new Network(new Synaps[]{input1, input2}, new Neuron[][]{new Neuron[]{layer1},new Neuron[]{output}}, out);
		
		n.propagate();
		
		System.out.println(n.getOutput());

		
	}
	
}
