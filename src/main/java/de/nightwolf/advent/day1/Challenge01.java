package de.nightwolf.advent.day1;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

public class Challenge01 {

	private Challenge01() {
	}

	public static void main(String[] args) throws URISyntaxException, IOException {
		var result = calculateNumberOfIncreases(new File(Objects.requireNonNull(Challenge01.class.getResource("input.txt")).toURI()));
		System.out.println(result);
	}

	public static int calculateNumberOfIncreases(File input) throws IOException {
		var numbers = Files.readAllLines(input.toPath(), StandardCharsets.UTF_8)
				.stream()
				.map(Integer::parseInt)
				.toList();

		return Day1Util.getNumberOfIncreases(numbers);
	}
}
