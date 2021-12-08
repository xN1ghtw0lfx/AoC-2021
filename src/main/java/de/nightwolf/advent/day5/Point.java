package de.nightwolf.advent.day5;
import java.util.Objects;
import java.util.StringJoiner;

public class Point {
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
		return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
				.add("x=" + x)
				.add("y=" + y)
				.toString();
	}
}
