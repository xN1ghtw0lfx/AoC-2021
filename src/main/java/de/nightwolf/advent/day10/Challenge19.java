package de.nightwolf.advent.day10;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Challenge19 {

	private static final List<Character> open = List.of('(', '[', '{', '<');
	private static final List<Character> close = List.of(')', ']', '}', '>');
	private static final Map<Character, Integer> points = Map.of(')', 3, ']', 57, '}', 1197, '>', 25137);

	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge19.class.getResource("input.txt")).toURI());
		System.out.println(getScore(filePath));
	}

	public static int getScore(Path filePath) throws IOException {
		var result = Files.readAllLines(filePath, StandardCharsets.UTF_8);
		var characters = new ArrayDeque<Character>();
		var score = 0;
		for (String s : result) {
			for (int i = 0; i < s.length(); i++) {
				var c = s.charAt(i);
				if (open.contains(c)) {
					characters.push(c);
				} else {
					var pop = characters.pop();
					var openChar = open.get(close.indexOf(c));
					if (!pop.equals(openChar)) {
						score += points.get(c);
					}
				}
			}
		}

		return score;
	}
}
