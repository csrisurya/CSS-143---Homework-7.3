import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode("");
    }
    public void insert(String word){
        word = word.toLowerCase();
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(!current.children.containsKey(letter)){
                TrieNode node = new TrieNode(word.substring(0, i + 1));
                current.children.put(letter, node);
            }
            current = current.children.get(letter);
        }
        current.IsWord = true;
    }
    public List<String> search(String searchString){
        searchString = searchString.toLowerCase();
        List<String> result = new ArrayList<>();
        TrieNode current = root;
        for(char letter : searchString.toCharArray()){
            if(current.children.containsKey(letter)){
                current = current.children.get(letter);
            }
            else{
                return result;
            }
        }

        findAllChildrenWords(current, result);
        return result;
    }
    private void findAllChildrenWords(TrieNode current, List<String> result){
        if(current.IsWord){
            result.add(current.prefix);
        }
        for(Character c : current.children.keySet()){
            current = current.children.get(c);
            findAllChildrenWords(current, result);
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
//      trie.insert("hello");
//      trie.insert("high");
      trie.insert("seattle");
      trie.insert("seatac");
      trie.insert("see");
//      trie.insert("hollow");
//      trie.insert("how");

        List<String> result = trie.search("s");
        System.out.println(result.toString());

        }
    }


