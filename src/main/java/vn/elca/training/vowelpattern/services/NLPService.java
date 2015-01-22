package vn.elca.training.vowelpattern.services;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import vn.elca.training.vowelpattern.services.exceptions.InvalidInputException;

public class NLPService {
	
	private static final Set<String> VOWELS = new HashSet<String>();
	
	static {
		VOWELS.add("A");
		VOWELS.add("E");
		VOWELS.add("I");
		VOWELS.add("O");
		VOWELS.add("U");
	}
	
	/**
	 * Check to see if 2 strings have the same vowels pattern
	 * 
	 * @param s1: first string
	 * @param s2: second string
	 * @return true of 2 strings have the same vowel pattern
	 * @throws InvalidInputException
	 */
	public boolean sameVowelPatternOfLongWord(String s1, String s2) 
			throws InvalidInputException {
		Stack<String> s1Pattern = getVowelsPatternOfString(s1);
		Stack<String> s2Pattern = getVowelsPatternOfString(s2);
		
		while (!s1Pattern.isEmpty() && !s2Pattern.isEmpty()) {
			if (s1Pattern.pop().compareTo(s2Pattern.pop()) != 0) {
				return false;
			}
		}
		
		return s1Pattern.isEmpty() && s2Pattern.isEmpty();
	}
	
	private Stack<String> getVowelsPatternOfString(String s) {
		Stack<String> vowels = new Stack<String>();
		
		for (int i = 0; i < s.length(); i++) {
			String candidate = String.valueOf(s.charAt(i));
			if (VOWELS.contains(candidate)) {
				vowels.push(candidate);
			}
		}
		
		return vowels;
	}
}
