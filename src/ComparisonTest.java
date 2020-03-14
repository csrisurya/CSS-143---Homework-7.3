import java.util.ArrayList;
import java.util.List;

public class ComparisonTest {
    public static void main(String[] args) {
        testTrieSearch();
        testStringComparison();
    }

    private static void testTrieSearch() {
        String[] words = {"hello", "high", "seattle", "seatac", "see", "hollow", "how"};
        String[] searchKeys = {"h", "se", "sea", "ho", "xyz", "z", "app"};
        int dictSize = 1;
        for (int i = 0; i < words.length; i++) {
            List<String> dict = new ArrayList<>();
            for (int j = 0; j < dictSize; j++) {
                dict.add(words[i]);
            }
            dictSize++;
            Trie trie = new Trie(dict);
            long startTime = System.nanoTime();
            trie.search(searchKeys[i]);
            long endTime = System.nanoTime();
            System.out.println("searching time for Trie for size " + (dictSize - 1) + " : " + (endTime - startTime));
        }
    }


    private static void testStringComparison() {
        String[] words = {"hello", "high", "seattle", "seatac", "see", "hollow", "how"};
        String[] searchKeys = {"h", "se", "sea", "ho", "xyz", "z", "app"};
        int dictSize = 1;
        for (int i = 0; i < words.length; i++) {
            List<String> dict = new ArrayList<>();
            for (int j = 0; j < dictSize; j++) {
                dict.add(words[i]);
            }
            dictSize++;
            Trie trie = new Trie(dict);
            long startTime = System.nanoTime();
            trie.justStringComparison(dict, searchKeys[i]);
            long endTime = System.nanoTime();
            System.out.println("searching time for string comparison for size " + (dictSize - 1) + " : " + (endTime - startTime));
        }
    }
}
