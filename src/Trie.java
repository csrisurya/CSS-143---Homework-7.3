import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
    private TrieNode root;
    public Trie(List<String> dict){
        root = new TrieNode("");
        for(String word : dict){
            insert(word);
        }
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
        for(int i = 0; i < searchString.length(); i++){
            char letter = searchString.charAt(i);
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
            findAllChildrenWords(current.children.get(c), result);
        }
    }
    public List<String> justStringComparison(List<String> dict, String searchString){
        List<String> result = new ArrayList<>();
        for(String string : dict){
            if(string.startsWith(searchString)){
                result.add(string);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("hello");
        dict.add("high");
        dict.add("seattle");
        dict.add("seatac");
        dict.add("see");
        dict.add("hollow");
        dict.add("how");
        Trie trie = new Trie(dict);

        List<String> actual =trie.search("xyz");
        System.out.println(actual.toString());
        Collections.sort(actual);
        System.out.println(actual.toString());

    }

}


