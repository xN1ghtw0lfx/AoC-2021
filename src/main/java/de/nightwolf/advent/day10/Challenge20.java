package de.nightwolf.advent.day10;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Challenge20 {

	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge20.class.getResource("input.txt")).toURI());

		var result = Files.readAllLines(filePath, StandardCharsets.UTF_8);

		var open = List.of('(', '[', '{', '<');
		var close = List.of(')', ']', '}', '>');
		var points = Map.of(')', 1, ']', 2, '}', 3, '>', 4);

		var scores = new ArrayList<Long>();
		o:
		for (String s : result) {
			var characters = new Stack<Character>();
			for (int i = 0; i < s.length(); i++) {
				var c = s.charAt(i);
				if (open.contains(c)) {
					characters.push(c);
				} else if (close.contains(c)) {
					var pop = characters.pop();
					var i1 = close.indexOf(c);
					var o = open.get(i1);
					if (!pop.equals(o)) {
						continue o;
					}
				} else {
					throw new IllegalArgumentException("Illegal character " + c);
				}
			}

			Collections.reverse(characters);

			var reduce = characters.stream()
					.map(c1 -> close.get(open.indexOf(c1)))
					.reduce(0L, (l, c) -> l * 5 + points.get(c), Long::sum);

			scores.add(reduce);
		}

		scores.sort(Long::compareTo);
		System.out.println(scores);
		System.out.println(scores.get(scores.size() / 2));
	}
}
