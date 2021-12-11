package de.nightwolf.advent.day10;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Challenge19Test {

	@Test
	void getScore() throws URISyntaxException, IOException {
		var filePath = Path.of(Objects.requireNonNull(Challenge19Test.class.getResource("input.txt")).toURI());
		Assertions.assertThat(Challenge19.getScore(filePath)).isEqualTo(26397);
	}
}