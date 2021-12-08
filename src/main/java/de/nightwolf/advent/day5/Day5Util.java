package de.nightwolf.advent.day5;
import java.util.Map;

public class Day5Util {
	private Day5Util() {
	}

	public static void printMap(Map<Point, Integer> points) {
		var max = points.keySet().stream().map(p -> Math.max(p.getX(), p.getY())).mapToInt(i -> i).max().orElseThrow();
		for (int i = 0; i <= max; i++) {
			for (int j = 0; j <= max; j++) {
				var integer = points.get(new Point(j, i));
				System.out.print(integer == null ? "." : integer);
			}
			System.out.println();
		}
	}
}
