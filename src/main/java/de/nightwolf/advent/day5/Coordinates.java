package de.nightwolf.advent.day5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Coordinates {

	private final Point start;
	private final Point end;

	public Coordinates(int x1, int y1, int x2, int y2) {
		this.start = new Point(x1, y1);
		this.end = new Point(x2, y2);
	}

	public boolean isHorizontal() {
		return start.getX() == end.getX();
	}

	public boolean isVertical() {
		return start.getY() == end.getY();
	}

	public boolean isHorizontalOrVertical() {
		return isHorizontal() || isVertical();
	}

	public boolean isDiagonal() {
		return Math.abs(start.getX() - end.getX()) == Math.abs(start.getY() - end.getY());
	}

	public boolean isHorizontalOrVerticalOrDiagonal() {
		return isHorizontalOrVertical() || isDiagonal();
	}

	public List<Point> getPoints() {
		if (isHorizontal()) {
			int x = start.getX();
			return IntStream.rangeClosed(Math.min(start.getY(), end.getY()), Math.max(start.getY(), end.getY()))
					.mapToObj(i -> new Point(x, i))
					.collect(Collectors.toList());
		} else if (isVertical()) {
			int y = start.getY();
			return IntStream.rangeClosed(Math.min(start.getX(), end.getX()), Math.max(start.getX(), end.getX()))
					.mapToObj(i -> new Point(i, y))
					.collect(Collectors.toList());
		} else if (isDiagonal()) {
			var x = IntStream.rangeClosed(Math.min(start.getX(), end.getX()), Math.max(start.getX(), end.getX())).boxed()
					.collect(Collectors.toList());
			var y = IntStream.rangeClosed(Math.min(start.getY(), end.getY()), Math.max(start.getY(), end.getY())).boxed()
					.collect(Collectors.toList());

			if (start.getX() > end.getX()) {
				Collections.reverse(x);
			}
			if (start.getY() > end.getY()) {
				Collections.reverse(y);
			}

			var points = new ArrayList<Point>();
			for (int i = 0; i < x.size(); i++) {
				points.add(new Point(x.get(i), y.get(i)));
			}
			return points;
		}

		throw new UnsupportedOperationException("Only horizontal and vertical coordinates are supported.");
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Coordinates.class.getSimpleName() + "[", "]")
				.add("start=" + start)
				.add("end=" + end)
				.toString();
	}
}
