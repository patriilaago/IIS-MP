package uo.mp.lab11;

import uo.mp.lab11.application.simulator.Simulator;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		new Simulator().simulate();
		
	}
}
