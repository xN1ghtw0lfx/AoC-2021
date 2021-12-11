package de.nightwolf.advent.day10;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Challenge20Test {

	@Test
	void getScore() throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge20Test.class.getResource("input.txt")).toURI());
		Assertions.assertThat(Challenge20.getScore(filePath)).isEqualTo(288957);
	}
}