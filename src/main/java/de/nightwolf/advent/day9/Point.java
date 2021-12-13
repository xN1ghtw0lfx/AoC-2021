package de.nightwolf.advent.day9;
public record Point(int x, int y) {

	public boolean valid(int[][] numbers) {
		return y >= 0 && y < numbers.length && x >= 0 && x < numbers[y].length && getValue(numbers) != 9;
	}

	public int getValue(int[][] numbers) {
		return numbers[y][x];
	}

}
