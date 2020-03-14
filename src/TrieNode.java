
import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean IsWord;
    String prefix;

    public TrieNode(String prefix){
        children = new HashMap<>();
        IsWord = false;
        this.prefix = prefix;
    }
}