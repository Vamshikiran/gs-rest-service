package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class WordController {

    // TODO Implement the /words/{word} endpoint
    @RequestMapping(value = "/words/{word}")
    @ResponseBody
    public WordModel words(@PathVariable("word") String word) {
        return new WordModel(word, isPalindrome(word), isAnagram(word));
    }

    private static boolean isPalindrome(String word) {
        boolean isEven = word.length() % 2 == 0;
        return isPalindrome(word, isEven, isEven ? 0 : 1);
    }

    private static boolean isPalindrome(String word, boolean isEven, int offset) {
        int midpoint = word.length() / 2;
        if (offset > midpoint + (isEven ? -1 : 0)) {
            return true;
        }
        char xchar = word.charAt(midpoint - offset + (isEven ? -1 : 0));
        char ychar = word.charAt(midpoint + offset);
        if (xchar != ychar) {
            return false;
        }
        return isPalindrome(word, isEven, offset + 1);
    }

    public boolean isAnagram(String word) {

        Map<Character, Integer> anagram = new HashMap();

        for (final Character c : word.toCharArray()) {
            if (anagram.containsKey(c)) {
                anagram.put(c, 1 + anagram.get(c));
            } else {
                anagram.put(c, 1);
            }
        }
        anagram.entrySet().stream().forEach(e -> e.getValue());

        List<Integer> oddOccurences = anagram.entrySet().stream()
                .map(e -> e.getValue())
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());

        return oddOccurences.size() > 1 ? false : true;
    }


}
