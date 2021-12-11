package de.nightwolf.advent.day9;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

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
		var up = new Point(parent.getX(), parent.getY() - 1);
		if (up.valid(numbers) && !basin.contains(up)) {
			basin.add(up);
			addNeighborToBasin(basin, up, numbers);
		}
		var right = new Point(parent.getX() + 1, parent.getY());
		if (right.valid(numbers) && !basin.contains(right)) {
			basin.add(right);
			addNeighborToBasin(basin, right, numbers);
		}
		var down = new Point(parent.getX(), parent.getY() + 1);
		if (down.valid(numbers) && !basin.contains(down)) {
			basin.add(down);
			addNeighborToBasin(basin, down, numbers);
		}
		var left = new Point(parent.getX() - 1, parent.getY());
		if (left.valid(numbers) && !basin.contains(left)) {
			basin.add(left);
			addNeighborToBasin(basin, left, numbers);
		}
	}

	public static class Basin {

		private final List<Point> points;

		public Basin() {
			points = new ArrayList<>();
		}

		public void add(Point point) {
			points.add(point);
		}

		public boolean contains(Point point) {
			return points.contains(point);
		}

		public int size() {
			return points.size();
		}

		public void print(int[][] numbers) {
			var minX = points.stream().mapToInt(Point::getX).min().orElseThrow();
			var maxX = points.stream().mapToInt(Point::getX).max().orElseThrow();
			var minY = points.stream().mapToInt(Point::getY).min().orElseThrow();
			var maxY = points.stream().mapToInt(Point::getY).max().orElseThrow();

			System.out.println(this);
			for (int i = minY; i < maxY; i++) {
				for (int j = minX; j < maxX; j++) {
					var point = new Point(j, i);
					if (contains(point)) {
						System.out.print(numbers[i][j] + " ");
					} else {
						System.out.print("  ");
					}
				}
				System.out.println();
			}
		}

		@Override
		public String toString() {
			return new StringJoiner(", ", Basin.class.getSimpleName() + "[", "]")
					.add("size=" + points.size())
					.add("points=" + points)
					.toString();
		}
	}

	public static class Point {
		private final int x;
		private final int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public boolean valid(int[][] numbers) {
			return y >= 0 && y < numbers.length && x >= 0 && x < numbers[y].length && getValue(numbers) != 9;
		}

		public int getValue(int[][] numbers) {
			return numbers[y][x];
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Point point = (Point) o;
			return getX() == point.getX() && getY() == point.getY();
		}

		@Override
		public int hashCode() {
			return Objects.hash(getX(), getY());
		}

		@Override
		public String toString() {
			return "Point{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}
}
