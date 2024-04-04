package Trie.PD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trie{
	 TrieNode root = new TrieNode();

public class TrieNode {

	private Map<Character, TrieNode> child; // child for  the trie
	private boolean wordEnd;// when the end of the word is reached 
	private ArrayList<Integer> location; 

public ArrayList<Integer> getLocation() {
		return location;
	}

	public void setLocation(ArrayList<Integer> location) {
		this.location = location;
	}

		//constructor
	    public TrieNode() {
	        child = new HashMap<>();
	        wordEnd = false;
	       // root = new TrieNode();
	    }
}
	 public void insert(String wordWanted) {
	        TrieNode current = root; // the current character we are at (the root for while)
	
	        for (int i = 0; i < wordWanted.length(); i++) {
	            char characterUsed = wordWanted.charAt(i); // character at current location
	            TrieNode nodeUsed = current.child.get(characterUsed); //child character in the trie
	 
	           // if the there’s nothing in the node insert a character with it’s location into the trie
				if (nodeUsed == null) {
					nodeUsed = new TrieNode(); 
				    current.child.put(characterUsed, nodeUsed);
				 }
				current = nodeUsed; // variable to show where we’re at. 
	        }
	        current.wordEnd = true;
 }

	    public ArrayList<Integer> search(String wordWanted) {
	        TrieNode current = root; // the current character we are at (the root for while)
	        //searches through each character to check for a child 
	        for (int i = 0; i < wordWanted.length(); i++) {
	            char characterUsed = wordWanted.charAt(i);
	            TrieNode nodeUsed = current.child.get(characterUsed);
	            if (nodeUsed == null) {
	                return new ArrayList<>();
	            }
	            current = nodeUsed;// update current 
	        }
	        if(!current.wordEnd) {
	        	return new ArrayList<>(); 
	        }
	        return current.getLocation(); // returns end of the word
	    }
	}



