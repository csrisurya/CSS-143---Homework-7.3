import java.util.*;

public class Trie {
    private final TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(!current.children.containsKey(letter)){
                TrieNode node = new TrieNode();
                current.children.put(letter, node);
            }
            current = current.children.get(letter);
        }
        current.endOfWord = true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("sea");
        trie.insert("seattle");
        System.out.println(trie);
        }
    }


