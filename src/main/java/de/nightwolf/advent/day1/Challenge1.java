package de.nightwolf.advent.day1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@SuppressWarnings("ConstantConditions")
public class Challenge1 {

	public static void main(String[] args) throws IOException {
		var numbers = new ArrayList<Integer>();
		try (var br = new BufferedReader(new InputStreamReader(Challenge1.class.getResourceAsStream("numbers.txt"), StandardCharsets.UTF_8))) {
			String line;
			while ((line = br.readLine()) != null) {
				numbers.add(Integer.parseInt(line));
			}
		}

		int increaseCount = Day1Util.getNumberOfIncreases(numbers);

		System.out.println(increaseCount);
	}
}
