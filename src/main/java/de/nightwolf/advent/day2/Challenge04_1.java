package de.nightwolf.advent.day2;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Challenge04_1 {

	public static void main(String[] args) throws URISyntaxException, IOException {
		var h = new AtomicInteger();
		var a = new AtomicInteger();
		var d = new AtomicInteger();
		Files.readAllLines(Path.of(Challenge04_1.class.getResource("subInput.txt").toURI()), StandardCharsets.UTF_8)
				.stream()
				.map(str -> str.split(" "))
				.map(arr -> new AbstractMap.SimpleImmutableEntry<>(arr[0], Integer.parseInt(arr[1])))
				.forEach(e -> {
					switch (e.getKey()) {
						case "forward" -> {
							h.addAndGet(e.getValue());
							d.addAndGet(a.get() * e.getValue());
						}
						case "up" -> a.addAndGet(Math.negateExact(e.getValue()));
						case "down" -> a.addAndGet(e.getValue());
						default -> throw new IllegalArgumentException("'%s' isn't really a valid direction.".formatted(e.getKey()));
					}
				});
		System.out.println(h.get() * d.get());
	}
}
