package de.nightwolf.advent.day9;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

public class Challenge17 {
	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge17.class.getResource("input.txt")).toURI());

		var result = Files.readAllLines(filePath, StandardCharsets.UTF_8);

		var numbers = new int[result.size()][];
		for (int i = 0; i < result.size(); i++) {
			var str = result.get(i);
			numbers[i] = new int[str.length()];
			for (int j = 0; j < str.length(); j++) {
				var c = str.charAt(j);
				var value = c - '0';

				numbers[i][j] = value;
			}
		}

		System.out.println(Arrays.deepToString(numbers));

		var sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if ((i - 1 >= 0 && numbers[i - 1][j] <= numbers[i][j]) //Up
						|| (j + 1 < numbers[i].length && numbers[i][j + 1] <= numbers[i][j])//Right
						|| (i + 1 < numbers.length && numbers[i + 1][j] <= numbers[i][j])//Down
						|| (j - 1 >= 0 && numbers[i][j - 1] <= numbers[i][j])) {//Left
					continue;
				}

				System.out.println("Lowpoint at x=%d y=%d with number %d".formatted(j, i, numbers[i][j]));
				sum += numbers[i][j] + 1;
			}
		}

		System.out.println("Sum of all lowest points " + sum);
	}
}
