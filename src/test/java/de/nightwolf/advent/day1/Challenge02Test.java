package de.nightwolf.advent.day1;
import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Challenge02Test {

	@Test
	void getIncreaseCount() throws IOException {
		var inputStream = Challenge02Test.class.getResourceAsStream("input.txt");
		Assertions.assertThat(Challenge02.getIncreaseCount(inputStream)).isEqualTo(5);
	}
}