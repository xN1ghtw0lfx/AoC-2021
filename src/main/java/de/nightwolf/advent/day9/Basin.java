package de.nightwolf.advent.day9;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Basin {

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
		var minX = points.stream().mapToInt(Point::x).min().orElseThrow();
		var maxX = points.stream().mapToInt(Point::x).max().orElseThrow();
		var minY = points.stream().mapToInt(Point::y).min().orElseThrow();
		var maxY = points.stream().mapToInt(Point::y).max().orElseThrow();

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
