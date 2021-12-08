package de.nightwolf.advent.day6;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

public class Challenge12 {

	public static final int DAYS = 256;

	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge12.class.getResource("input.txt")).toURI());

		System.out.println("Number of fish: " + Day6Util.getNumberOfFish(filePath, DAYS, 6, 2));
	}
}
