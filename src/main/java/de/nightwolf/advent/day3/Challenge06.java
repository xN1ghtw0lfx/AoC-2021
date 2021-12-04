package de.nightwolf.advent.day3;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Challenge06 {
	public static void main(String[] args) throws URISyntaxException, IOException {
		var oxy = Files.readAllLines(Path.of(Challenge06.class.getResource("input.txt").toURI()), StandardCharsets.UTF_8);
		var co2 = new ArrayList<>(oxy);

		var oxyStr = getCommonBits(oxy, false);
		var co2Str = getCommonBits(co2, true);
		System.out.println(oxyStr);
		System.out.println(co2Str);

		var oxyDec = Integer.parseInt(oxyStr, 2);
		var co2Dec = Integer.parseInt(co2Str, 2);

		System.out.println(oxyDec);
		System.out.println(co2Dec);
		System.out.println(oxyDec * co2Dec);
	}

	public static String getCommonBits(List<String> strings, boolean leastCommon) {
		strings = new ArrayList<>(strings);
		var cursor = 0;
		var counter = 0;
		while (strings.size() > 1) {
			for (String str : strings) {
				var c = str.charAt(cursor);
				if (c == '1') {
					counter++;
				} else {
					counter--;
				}
			}
			var iterator = strings.iterator();
			if ((counter >= 0 && !leastCommon) || (counter < 0 && leastCommon)) {
				while (iterator.hasNext()) {
					String next = iterator.next();
					if (next.charAt(cursor) == '0') {
						iterator.remove();
					}
				}
			} else {
				while (iterator.hasNext()) {
					String next = iterator.next();
					if (next.charAt(cursor) == '1') {
						iterator.remove();
					}
				}
			}
			cursor++;
			counter = 0;
		}

		return strings.get(0);
	}
}
