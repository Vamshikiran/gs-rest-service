package hello;

/**
 * Created by vamshikirangullapelly on 03/11/2018.
 */
public class WordModel {
    private final String word;
    private final boolean palindrome;
    private final boolean anagramOfPalindrome;

    public WordModel(String word, boolean palindrome, boolean anagramOfPalindrome) {
        this.word = word;
        this.palindrome = palindrome;
        this.anagramOfPalindrome = anagramOfPalindrome;
    }

    public String getWord() {
        return word;
    }

    public boolean isPalindrome() {
        return palindrome;
    }

    public boolean isAnagramOfPalindrome() {
        return anagramOfPalindrome;
    }
}
