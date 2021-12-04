package de.nightwolf.advent.day3;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@SuppressWarnings("ALL")
public class Challenge05 {
	public static void main(String[] args) throws URISyntaxException, IOException {
		var strings = Files.readAllLines(Path.of(Challenge05.class.getResource("input.txt").toURI()), StandardCharsets.UTF_8);
		int[] numbers = null;
		for (String string : strings) {
			if (numbers == null) {
				numbers = new int[string.length()];
			}
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) == '1') {
					numbers[i]++;
				} else {
					numbers[i]--;
				}
			}
		}

		System.out.println(Arrays.toString(numbers));

		String gamma = "";
		String epsilon = "";
		for (int number : numbers) {
			if (number == 0) {
				throw new IllegalArgumentException("WTF?");
			} else if (number > 0) {
				gamma += "1";
				epsilon += "0";
			} else {
				gamma += "0";
				epsilon += "1";
			}
		}

		System.out.println(gamma);
		System.out.println(epsilon);

		var gammaDec = Integer.parseInt(gamma, 2);
		var epsiDec = Integer.parseInt(epsilon, 2);

		System.out.println(gammaDec);
		System.out.println(epsiDec);

		System.out.println(gammaDec * epsiDec);
	}
}
