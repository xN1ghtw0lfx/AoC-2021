package de.nightwolf.advent.day8;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Challenge15 {

	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge15.class.getResource("input.txt")).toURI());

		var result = Files.readAllLines(filePath, StandardCharsets.UTF_8).stream()
				.map(str -> str.split(" \\| "))
				.map(s -> Input.parseInput(s[0], s[1]))
				.map(Input::calculateNumberOfEasyDigets)
				.reduce(0, Integer::sum);

		System.out.println(result);
	}

	public static class Input {
		List<String> signalPattern;
		List<String> output;

		public Input(List<String> signalPattern, List<String> output) {
			this.signalPattern = signalPattern;
			this.output = output;
		}

		public static Input parseInput(String signalPattern, String output) {
			var signals = Arrays.stream(signalPattern.split(" "))
					.map(String::toCharArray)
					.peek(Arrays::sort)
					.map(String::new)
					.collect(Collectors.toList());
			var outputs = Arrays.stream(output.split(" "))
					.map(String::toCharArray)
					.peek(Arrays::sort)
					.map(String::new)
					.collect(Collectors.toList());
			return new Input(signals, outputs);
		}

		public int calculateNumberOfEasyDigets() {
			var strings = signalPattern.stream().filter(s -> s.length() == 2 || s.length() == 3 || s.length() == 4 || s.length() == 7)
					.collect(Collectors.toList());
			int count = 0;
			for (String s : output) {
				if (strings.contains(s)) {
					count++;
				}
			}

			return count;
		}
	}

}
