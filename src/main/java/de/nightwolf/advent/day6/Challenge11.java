package de.nightwolf.advent.day6;
import static de.nightwolf.advent.day6.Day6Util.getNumberOfFish;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

public class Challenge11 {

	public static final int DAYS = 80;

	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge11.class.getResource("input.txt")).toURI());
		
		System.out.println("Number of fish: " + getNumberOfFish(filePath, DAYS, 6, 2));
	}
}
