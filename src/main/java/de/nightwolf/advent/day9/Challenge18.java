package de.nightwolf.advent.day9;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Challenge18 {
	public static void main(String[] args) throws IOException, URISyntaxException {
		var filePath = Path.of(Objects.requireNonNull(Challenge18.class.getResource("input.txt")).toURI());

		var result = Files.readAllLines(filePath, StandardCharsets.UTF_8);

		var numbers = new int[result.size()][];
		for (int i = 0; i < result.size(); i++) {
			var str = result.get(i);
			numbers[i] = new int[str.length()];
			for (int j = 0; j < str.length(); j++) {
				var c = str.charAt(j);
				var value = c - '0';

				numbers[i][j] = value;
			}
		}

		for (int[] number : numbers) {
			for (int i : number) {

				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println();
		}

		var basins = new ArrayList<Basin>();
		for (int i = 0; i < numbers.length; i++) {
			x:
			for (int j = 0; j < numbers[i].length; j++) {
				var point = new Point(j, i);
				if (!point.valid(numbers)) {
					continue;
				}
				for (Basin basin : basins) {
					if (basin.contains(point)) {
						continue x;
					}
				}

				basins.add(calculateBasin(point, numbers));
			}
		}
		basins.sort(Comparator.comparing(Basin::size).reversed());

		for (Basin basin : basins.subList(0, 3)) {
			basin.print(numbers);
		}

		System.out.println("Solution: " + basins.subList(0, 3).stream().mapToInt(Basin::size).reduce((i1, i2) -> i1 * i2).orElseThrow());
	}

	public static Basin calculateBasin(Point startPoint, int[][] numbers) {
		var basin = new Basin();
		basin.add(startPoint);
		addNeighborToBasin(basin, startPoint, numbers);
		return basin;
	}

	public static void addNeighborToBasin(Basin basin, Point parent, int[][] numbers) {
		var up = new Point(parent.x(), parent.y() - 1);
		if (up.valid(numbers) && !basin.contains(up)) {
			basin.add(up);
			addNeighborToBasin(basin, up, numbers);
		}
		var right = new Point(parent.x() + 1, parent.y());
		if (right.valid(numbers) && !basin.contains(right)) {
			basin.add(right);
			addNeighborToBasin(basin, right, numbers);
		}
		var down = new Point(parent.x(), parent.y() + 1);
		if (down.valid(numbers) && !basin.contains(down)) {
			basin.add(down);
			addNeighborToBasin(basin, down, numbers);
		}
		var left = new Point(parent.x() - 1, parent.y());
		if (left.valid(numbers) && !basin.contains(left)) {
			basin.add(left);
			addNeighborToBasin(basin, left, numbers);
		}
	}

}
