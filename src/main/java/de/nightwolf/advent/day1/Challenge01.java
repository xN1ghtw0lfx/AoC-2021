package de.nightwolf.advent.day1;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@SuppressWarnings("ConstantConditions")
public class Challenge01 {

	public static void main(String[] args) throws IOException, URISyntaxException {
		var numbers = Files.readAllLines(Path.of(Challenge01.class.getResource("numbers.txt").toURI()), StandardCharsets.UTF_8)
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		int increaseCount = Day1Util.getNumberOfIncreases(numbers);

		System.out.println(increaseCount);
	}
}
