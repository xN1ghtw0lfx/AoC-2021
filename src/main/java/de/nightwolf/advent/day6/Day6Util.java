package de.nightwolf.advent.day6;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day6Util {

	private Day6Util() {
	}

	public static long getNumberOfFish(Path filePath, int numberOfDays, int daysUntilBirth, int additionalDaysForNewBorn) throws IOException {
		var fish = Files.readAllLines(filePath, StandardCharsets.UTF_8).stream()
				.map(str -> str.split(","))
				.flatMap(Arrays::stream)
				.map(Long::valueOf)
				.collect(Collectors.toMap(Long::intValue, p -> 1L, Long::sum));

		System.out.println("Initial state: " + fish);
		for (int i = 0; i < numberOfDays; i++) {
			Map<Integer, Long> tempFish = new HashMap<>();
			for (int j = 0; j < daysUntilBirth + additionalDaysForNewBorn + 1; j++) {
				var numberOfFish = fish.get(j);
				if (numberOfFish != null) {
					if (j == 0) {
						tempFish.put(daysUntilBirth, numberOfFish);
						tempFish.put(daysUntilBirth + additionalDaysForNewBorn, numberOfFish);
					} else if (j == daysUntilBirth + 1) {
						tempFish.merge(j - 1, numberOfFish, Long::sum);
					} else {
						tempFish.put(j - 1, numberOfFish);
					}
				}
			}

			fish = tempFish;
			System.out.println("After %03d day: %s".formatted(i + 1, fish));
		}

		return fish.values().stream().mapToLong(l -> l).sum();
	}
}
