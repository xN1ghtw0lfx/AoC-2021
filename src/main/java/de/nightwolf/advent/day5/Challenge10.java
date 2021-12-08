package de.nightwolf.advent.day5;
import static de.nightwolf.advent.day5.Day5Util.printMap;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Challenge10 {

	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge10.class.getResource("input.txt")).toURI());
		var points = Files.readAllLines(filePath, StandardCharsets.UTF_8).stream()
				.map(str -> str.replace(" -> ", ","))
				.map(str -> str.split(","))
				.map(s -> new Coordinates(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3])))
				.filter(Coordinates::isHorizontalOrVerticalOrDiagonal)
				.map(Coordinates::getPoints)
				.flatMap(Collection::stream)
				.collect(Collectors.toMap(Function.identity(), p -> 1, Integer::sum));

		System.out.println("Solution: " + points.entrySet().stream().filter(e -> e.getValue() > 1).count());
		printMap(points);
	}
}
