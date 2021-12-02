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
				System.out.println(number + " N/A");
				continue;
			}
			if (lastNumber < number) {
				increaseCount++;
				System.out.println(number + " increase");
			} else {
				System.out.println(number + " decrease");
			}
			lastNumber = number;
		}

		return increaseCount;
	}
}
