package trie;

public class TrieClient {
	
	public static class Trie {
		
		private class Node{
			Node[] children;
			boolean isEnd;
			
			Node(){
				children = new Node[26];
			}
		}
		
		final private Node root;
	    /** Initialize your data structure here. */
	    public Trie() {
	    	root = new Node();
	    }

	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	    	Node curr = root;
	    	for(int i = 0; i < word.length(); i++) {
	    		char ch = word.charAt(i);
	    		
	    		if(curr.children[ch - 'a'] == null) {
	    			curr.children[ch - 'a'] = new Node();
	    		}
	    		curr = curr.children[ch - 'a'];
	    	}
	    	curr.isEnd = true;
	    }

	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	    	Node curr = root;
	    	for(int i = 0; i < word.length(); i++) {
	    		char ch = word.charAt(i);
	    		
	    		if(curr.children[ch -'a'] == null) return false;
	    		curr= curr.children[ch - 'a'];
	    	}
	    	return curr.isEnd;
	    }

	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	    	Node curr = root;
	    	for(int i = 0; i < prefix.length(); i++) {
	    		char ch = prefix.charAt(i);
	    		
	    		if(curr.children[ch -'a'] == null) return false;
	    		curr= curr.children[ch - 'a'];
	    	}
	    	return true;
	    }
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("card");
		trie.insert("cot");
		trie.insert("cots");
		trie.insert("calender");
		trie.insert("tree");
		trie.insert("temple");
		
		System.out.println(trie.search("cot"));

	}

}
