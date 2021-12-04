package de.nightwolf.advent.day4;
import static java.util.function.Predicate.not;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private final String name;
	private final List<List<Integer>> numbers;

	public Board(String name, List<List<Integer>> numbers) {
		this.name = name;
		this.numbers = numbers;
	}

	public boolean checkIfWon(List<Integer> calledNumbers) {
		List<Integer> n = new ArrayList<>();
		for (List<Integer> number : numbers) {
			for (Integer integer : number) {
				if (!calledNumbers.contains(integer)) {
					n = new ArrayList<>();
					break;
				}
				n.add(integer);
			}
			if (n.size() == 5) {
				return true;
			}
		}

		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < numbers.get(i).size(); j++) {
				var integer = numbers.get(j).get(i);
				if (!calledNumbers.contains(integer)) {
					n = new ArrayList<>();
					break;
				}
				n.add(integer);
			}
			if (n.size() == 5) {
				return true;
			}
		}

		for (int i = 0; i < numbers.size(); i++) {
			var integer = numbers.get(i).get(i);
			if (!calledNumbers.contains(integer)) {
				n = new ArrayList<>();
				break;
			}
			n.add(integer);

			if (n.size() == 5) {
				return true;
			}
		}

		for (int i = 0, j = numbers.get(i).size() - 1; j >= 0; j--, i++) {
			var integer = numbers.get(i).get(j);
			if (!calledNumbers.contains(integer)) {
				break;
			}
			n.add(integer);

			if (n.size() == 5) {
				return true;
			}
		}

		return false;
	}

	public int getSumOfUnmarked(List<Integer> calledNumbers) {
		return numbers.stream().flatMap(List::stream).filter(not(calledNumbers::contains)).mapToInt(i -> i).sum();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		var stringBuilder = new StringBuilder();
		stringBuilder.append("Board #").append(name).append(": \n");
		for (List<Integer> number : numbers) {
			for (Integer integer : number) {
				stringBuilder.append("%02d".formatted(integer)).append(" ");
			}
			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}
}
