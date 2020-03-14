import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class AutoCompleteTests {

    @Test
    public void testAutoComplete(){
        List<String> dict = new ArrayList<>();
        dict.add("hello");
        dict.add("high");
        dict.add("seattle");
        dict.add("seatac");
        dict.add("see");
        dict.add("hollow");
        dict.add("how");
        Trie trie = new Trie(dict);
        String[][] expected = {
                {"hello", "high", "hollow", "how"},
                {"seatac", "seattle", "see"},
                {"seatac", "seattle"},
                {"hollow", "how"},
                {}

        };
        String[] searchKeys = {"h", "se", "sea", "ho", "xyz"};

        for(int i = 0; i < expected.length; i++){
            List<String> actual = trie.search(searchKeys[i]);
            Collections.sort(actual);
            // needs to be sorted because the list returns the correct words but it isn't in alphabetical order
            assertEquals(Arrays.asList(expected[i]), actual);
        }


    }
}
