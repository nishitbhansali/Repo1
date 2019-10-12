package com.nishit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PrintDuplicatesFromString {

	public static void main(String[] args) {
		printDuplicatecharacters("Nishit");
		printDuplicatecharacters("Programming");
		printDuplicatecharacters("Discrete");
	}
	public static void printDuplicatecharacters(String word) {
		char[] character = word.toCharArray();
		//System.out.println(character);

		HashMap<Character, Integer> charHashMap = new HashMap<Character, Integer>();

		for(Character ch : character) {
			if(charHashMap.containsKey(ch)) {
				charHashMap.put(ch, charHashMap.get(ch)+1);
			}else {
				charHashMap.put(ch, 1);
			}
			//System.out.println(charHashMap);
		}

		Set<Map.Entry<Character, Integer>> charSet = charHashMap.entrySet();

		System.out.printf("List of Duplicate Characters '%s' %n ",word);
		for(Map.Entry<Character, Integer> entry	: charSet) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey()+"....."+entry.getValue());
			}
		}

	}

}
