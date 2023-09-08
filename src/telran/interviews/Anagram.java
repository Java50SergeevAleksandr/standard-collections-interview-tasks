package telran.interviews;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Anagram {
	public static boolean isAnagram(String str, String anagram) {
		boolean[] res = { false };

		if (str.length() == anagram.length()) {
			res[0] = true;
			HashMap<Integer, Integer> map = new HashMap<>();
			str.chars().forEach(c -> map.merge(c, 1, Integer::sum));			
			anagram.chars().takeWhile(c -> {
				return res[0] = map.get(c) != null && map.get(c) != 0;
			}).forEach(c -> map.compute(c, (k, value) -> value - 1));
		}

		return res[0];
	}

	
	
	public static boolean isAnagramClassSolution(String word, String anagram) {
		boolean res = false;
		if (word.length() == anagram.length()) {
			HashMap<Character, Integer> charCountsMap = getCharCounts(word);
			res = true;
			char[] anagramChars = anagram.toCharArray();
			int index = 0;
			while (index < anagramChars.length && res) {

				if (charCountsMap.compute(anagramChars[index++], (k, v) -> v == null ? -1 : v - 1) < 0) {
					res = false;
				}
			}
		}

		return res;
	}

	private static HashMap<Character, Integer> getCharCounts(String word) {
		HashMap<Character, Integer> res = new HashMap<>();
		for (char c : word.toCharArray()) {
			res.merge(c, 1, Integer::sum);
		}
		return res;
	}

}