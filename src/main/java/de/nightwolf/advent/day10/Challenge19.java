package de.nightwolf.advent.day10;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Challenge19 {

	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge19.class.getResource("input.txt")).toURI());

		var result = Files.readAllLines(filePath, StandardCharsets.UTF_8);

		var open = List.of('(', '[', '{', '<');
		var close = List.of(')', ']', '}', '>');
		var points = Map.of(')', 3, ']', 57, '}', 1197, '>', 25137);

		var characters = new Stack<Character>();
		var score = 0;
		for (String s : result) {
			for (int i = 0; i < s.length(); i++) {
				var c = s.charAt(i);
				if (open.contains(c)) {
					characters.push(c);
				} else if (close.contains(c)) {
					var pop = characters.pop();
					var i1 = close.indexOf(c);
					var o = open.get(i1);
					if (!pop.equals(o)) {
						var i2 = open.indexOf(pop);
						System.out.println("%s - Expected %s, but found %s instead.".formatted(s, close.get(i2), c));
						score += points.get(c);
					}
				} else {
					throw new IllegalArgumentException("Illegal character " + c);
				}
			}
		}

		System.out.println(score);
	}
}
