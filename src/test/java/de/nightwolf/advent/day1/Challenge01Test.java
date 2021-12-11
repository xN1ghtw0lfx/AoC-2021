package de.nightwolf.advent.day1;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import org.junit.jupiter.api.Test;

class Challenge01Test {

	@Test
	void calculateNumberOfIncreases() throws IOException, URISyntaxException {
		var challenge01 = Challenge01.calculateNumberOfIncreases(
				new File(Objects.requireNonNull(Challenge01Test.class.getResource("input.txt")).toURI()));
		assertThat(challenge01).isEqualTo(7);
	}
}