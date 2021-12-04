package de.nightwolf.advent.day4;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Challenge08 {

	public static void main(String[] args) throws URISyntaxException, IOException {
		var filePath = Path.of(Objects.requireNonNull(Challenge08.class.getResource("input.txt")).toURI());
		var winner = getScoreOfWinner(filePath);
		System.out.println(winner);
	}

	public static int getScoreOfWinner(Path filePath) throws IOException {
		var strings = Files.readAllLines(filePath, StandardCharsets.UTF_8);

		var numbers = Arrays.stream(strings.get(0).split(",")).map(Integer::valueOf).collect(Collectors.toList());

		List<Board> boards = new ArrayList<>();
		List<List<Integer>> boardNumbers = new ArrayList<>();
		for (int i = 2; i < strings.size(); i++) {
			var str = strings.get(i);
			if (str.isEmpty()) {
				continue;
			}

			var n = Arrays.stream(str.split(" ")).filter(s -> !s.isEmpty()).map(Integer::valueOf).collect(Collectors.toList());
			boardNumbers.add(n);
			if (boardNumbers.size() == 5) {
				boards.add(new Board(boards.size() + 1 + "", boardNumbers));
				boardNumbers = new ArrayList<>();
			}
		}

		for (int i = 0; i < numbers.size(); i++) {
			var iterator = boards.iterator();
			while (iterator.hasNext()) {
				Board board = iterator.next();
				var integers = numbers.subList(0, i + 1);
				if (board.checkIfWon(numbers.subList(0, i + 1))) {
					if (boards.size() == 1) {
						var lastNumber = numbers.get(i);
						System.out.println(
								"%s of board #%s has won with number %d after %d numbers".formatted(integers, board.getName(), lastNumber, i + 1));
						System.out.println(board);

						return board.getSumOfUnmarked(integers) * lastNumber;
					}

					iterator.remove();
				}
			}
		}

		return -1;
	}

}
