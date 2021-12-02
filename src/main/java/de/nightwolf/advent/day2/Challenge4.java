package de.nightwolf.advent.day2;
import de.nightwolf.advent.day2.submarine.Submarine;
import de.nightwolf.advent.day2.submarine.SubmarineV2;

public class Challenge4 {

	public static void main(String[] args) {
		Submarine submarine = new SubmarineV2();
		submarine.executeInput(Challenge3.class.getResourceAsStream("subInput.txt"));

		System.out.println(submarine.getPosition());
	}

}
