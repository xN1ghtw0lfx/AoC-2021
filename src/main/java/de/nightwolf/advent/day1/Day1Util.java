package de.nightwolf.advent.day1;
import java.util.List;

public class Day1Util {
	private Day1Util() {
	}

	public static int getNumberOfIncreases(List<Integer> numbers) {
		int increaseCount = 0;
		Integer lastNumber = null;
		for (Integer number : numbers) {
			if (lastNumber == null) {
				lastNumber = number;
				continue;
			}

			if (lastNumber < number) {
				increaseCount++;
			}

			lastNumber = number;
		}

		return increaseCount;
	}
}
