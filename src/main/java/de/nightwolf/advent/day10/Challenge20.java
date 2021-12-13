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

public class Challenge20 {

	private static final List<Character> open = List.of('(', '[', '{', '<');
	private static final List<Character> close = List.of(')', ']', '}', '>');
	private static final Map<Character, Integer> points = Map.of('(', 1, '[', 2, '{', 3, '<', 4);

	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge20.class.getResource("input.txt")).toURI());
		System.out.println(getScore(filePath));
	}

	public static Long getScore(Path filePath) throws IOException {
		var scores = Files.readAllLines(filePath, StandardCharsets.UTF_8).stream()
				.map(s -> {
					var characters = new ArrayDeque<Character>();
					for (int i = 0; i < s.length(); i++) {
						var c = s.charAt(i);
						if (open.contains(c)) {
							characters.push(c);
						} else {
							var pop = characters.pop();
							var openChar = open.get(close.indexOf(c));
							if (!pop.equals(openChar)) {
								return null;
							}
						}
					}
					return characters;
				})
				.filter(Objects::nonNull)
				.map(chars -> chars.stream().reduce(0L, (l, c) -> l * 5 + points.get(c), Long::sum))
				.sorted()
				.toList();
		return scores.get(scores.size() / 2);
	}
}
