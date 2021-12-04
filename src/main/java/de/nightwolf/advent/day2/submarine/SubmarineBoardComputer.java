package de.nightwolf.advent.day2.submarine;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;

public class SubmarineBoardComputer {

	private final Submarine submarine;

	SubmarineBoardComputer(Submarine submarine) {
		this.submarine = submarine;
	}

	public void executeInput(Path pathToInput) {
		try {
			Files.readAllLines(pathToInput, StandardCharsets.UTF_8)
					.stream()
					.map(str -> str.split(" "))
					.map(arr -> new AbstractMap.SimpleImmutableEntry<>(arr[0], Integer.parseInt(arr[1])))
					.forEach(e -> {
						switch (e.getKey()) {
							case "forward" -> submarine.forward(e.getValue());
							case "up" -> submarine.up(e.getValue());
							case "down" -> submarine.down(e.getValue());
							default -> throw new IllegalArgumentException("'%s' isn't really a valid direction.".formatted(e.getKey()));
						}
					});
		} catch (IOException e) {
			throw new IllegalArgumentException("Error while reading the input file.", e);
		}
	}
}
