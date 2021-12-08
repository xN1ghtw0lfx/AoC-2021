package de.nightwolf.advent.day7;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

public class Challenge13 {

	public static void main(String[] args) throws URISyntaxException, IOException {
		var filePath = Path.of(Objects.requireNonNull(Challenge13.class.getResource("input.txt")).toURI());

		var positions = Files.readAllLines(filePath, StandardCharsets.UTF_8).stream()
				.map(str -> str.split(","))
				.flatMap(Arrays::stream)
				.mapToInt(Integer::valueOf)
				.toArray();

		var min = Arrays.stream(positions).min().orElseThrow();
		var max = Arrays.stream(positions).max().orElseThrow();

		System.out.println(min);
		System.out.println(max);

		System.out.println("Sum of all positions: " + Arrays.stream(positions).sum());
		System.out.println("Size: " + positions.length);
		var maxPosition = Math.round((double) Arrays.stream(positions).sum() / positions.length);
		System.out.println("Max Position: " + maxPosition);

		Integer currentMinFuel = null;
		Integer currentMinPosition = null;
		outer:
		for (int i = min; i < maxPosition + 1; i++) {
			int currentFuelConsumption = 0;
			for (int position : positions) {
				currentFuelConsumption += Math.abs(i - position);

				if (currentMinFuel != null && currentFuelConsumption >= currentMinFuel) {
					continue outer;
				}
			}

			currentMinFuel = currentFuelConsumption;
			currentMinPosition = i;
		}

		System.out.println(currentMinFuel);
		System.out.println(currentMinPosition);
	}
}
