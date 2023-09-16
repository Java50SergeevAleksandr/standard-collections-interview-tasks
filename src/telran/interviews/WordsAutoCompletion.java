package telran.interviews;

import java.util.List;
import java.util.*;

public class WordsAutoCompletion implements Words {
	TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

	@Override
	public boolean addWord(String word) {
		return set.add(word);
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		return set.subSet(prefix, getLastElement(prefix)).stream().toList();
	}

	private String getLastElement(String prefix) {
		char lastChar = (char) (prefix.charAt(prefix.length() - 1) + 1);		
		return prefix.substring(0, prefix.length() - 1) + lastChar;
	}

}
