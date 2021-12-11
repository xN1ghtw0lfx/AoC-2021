package de.nightwolf.advent.day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.common.collect.EvictingQueue;

@SuppressWarnings({"UnstableApiUsage"})
public class Challenge02 {

	public static void main(String[] args) throws IOException {
		var inputStream = Challenge02.class.getResourceAsStream("input.txt");
		System.out.println(getIncreaseCount(inputStream));
	}

	public static int getIncreaseCount(InputStream inputStream) throws IOException {
		var numbers = new ArrayList<Integer>();
		var window = EvictingQueue.<Integer>create(3);

		try (var br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				window.add(Integer.parseInt(line));
				if (window.size() == 3) {
					numbers.add(window.stream().mapToInt(o -> o).sum());
				}
			}
		}

		return Day1Util.getNumberOfIncreases(numbers);
	}
}
