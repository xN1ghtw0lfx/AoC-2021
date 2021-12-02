package de.nightwolf.advent.day2.submarine;
import java.io.InputStream;

public abstract class Submarine {

	protected final SubmarineBoardComputer submarineBoardComputer;
	
	protected int horizontalPosition;
	protected int depth;

	public Submarine() {
		this.submarineBoardComputer = new SubmarineBoardComputer(this);
	}

	public void executeInput(InputStream input) {
		submarineBoardComputer.executeInput(input);
	}

	public abstract void forward(int units);

	public abstract void up(int units);

	public abstract void down(int units);

	public int getPosition() {
		return horizontalPosition * depth;
	}
}
