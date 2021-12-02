package de.nightwolf.advent.day2.submarine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class SubmarineBoardComputer {

	private static final Pattern pattern = Pattern.compile("(\\w*) (\\d*)");

	private final Submarine submarine;

	SubmarineBoardComputer(Submarine submarine) {
		this.submarine = submarine;
	}

	public void executeInput(InputStream input) {
		try (var br = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {

			String line;
			while ((line = br.readLine()) != null) {
				var matcher = pattern.matcher(line);
				if (!matcher.find()) {
					throw new IllegalArgumentException("What the fuck is this line '%s' supposed to mean?".formatted(line));
				}

				var direction = matcher.group(1);
				var units = Integer.parseInt(matcher.group(2));

				switch (direction) {
					case "forward" -> submarine.forward(units);
					case "up" -> submarine.up(units);
					case "down" -> submarine.down(units);
					default -> throw new IllegalArgumentException("'%s' isn't really a valid direction.".formatted(direction));
				}
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Error while reading the input file.", e);
		}
	}
}
