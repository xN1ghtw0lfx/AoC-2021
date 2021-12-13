package de.nightwolf.advent.day2.submarine;
public final class SubmarineV2 extends Submarine {

	private int aim;

	public SubmarineV2() {
	}

	public void forward(int units) {
		horizontalPosition += units;
		depth += aim * units;
	}

	public void up(int units) {
		aim -= units;
	}

	public void down(int units) {
		aim += units;
	}
}
