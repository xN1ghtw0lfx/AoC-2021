package de.nightwolf.advent.day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.common.collect.EvictingQueue;

@SuppressWarnings({"ConstantConditions", "UnstableApiUsage"})
public class Challenge02 {

	public static void main(String[] args) throws IOException {
		var numbers = new ArrayList<Integer>();
		var window = EvictingQueue.<Integer>create(3);

		try (var br = new BufferedReader(new InputStreamReader(Challenge02.class.getResourceAsStream("numbers.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				window.add(Integer.parseInt(line));
				if (window.size() == 3) {
					numbers.add(window.stream().mapToInt(o -> o).sum());
				}
			}
		}

		int increaseCount = Day1Util.getNumberOfIncreases(numbers);

		System.out.println(increaseCount);
	}
}
