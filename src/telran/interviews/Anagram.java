package telran.interviews;

import java.util.stream.Collectors;

public class Anagram {
	public static boolean isAnagram(String str, String anagram) {
		boolean[] res = { false };

		if (str.length() == anagram.length()) {
			res[0] = true;
			var map = str.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
			var stream = anagram.chars();
			
			stream.forEach(c -> map.compute(c, (k, value) -> {
				long out = 0;
				
				if (value == null || value == 0) {
					res[0] = false;
					stream.close();
				} else {
					out = value - 1;
				}
				
				return out;
			}));
		}

		return res[0];
	}
}
