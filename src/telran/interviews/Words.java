package telran.interviews;

import java.util.List;

public interface Words {
	/**
	 * adds word
	 * 
	 * @param word
	 *
	 * @return true if added, otherwise false if an word already exists (case
	 *         insensitive)
	 */
	boolean addWord(String word);

	/**
	 *
	 *
	 * @param prefix
	 *
	 * @return list of words (keeping on the case) starting from a given prefix
	 *         (prefix is case insensitive) - see test in the #3.2
	 */
	List<String> getWordsByPrefix(String prefix);
}
