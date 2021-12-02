package de.nightwolf.advent.day2.submarine;
public class SubmarineV1 extends Submarine {

	public SubmarineV1() {
	}

	public void forward(int units) {
		horizontalPosition += units;
	}

	public void up(int units) {
		depth -= units;
	}

	public void down(int units) {
		depth += units;
	}
}
