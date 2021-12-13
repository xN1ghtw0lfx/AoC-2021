package de.nightwolf.advent.day2.submarine;
import java.nio.file.Path;

public abstract sealed class Submarine permits SubmarineV1, SubmarineV2 {

	protected final SubmarineBoardComputer submarineBoardComputer;

	protected int horizontalPosition;
	protected int depth;

	public Submarine() {
		this.submarineBoardComputer = new SubmarineBoardComputer(this);
	}

	public void executeInput(Path pathToInput) {
		submarineBoardComputer.executeInput(pathToInput);
	}

	public abstract void forward(int units);

	public abstract void up(int units);

	public abstract void down(int units);

	public int getPosition() {
		return horizontalPosition * depth;
	}
}
