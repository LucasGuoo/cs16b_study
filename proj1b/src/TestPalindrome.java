import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("aaa"));
        assertTrue(palindrome.isPalindrome("noon"));

        assertTrue(palindrome.isPalindrome("ab",new OffByOne()));
        assertTrue(palindrome.isPalindrome("bca",new OffByOne()));
        assertTrue(palindrome.isPalindrome("abab",new OffByOne()));


        assertFalse(palindrome.isPalindrome("aA"));
        assertFalse(palindrome.isPalindrome("abc"));
        assertFalse(palindrome.isPalindrome("abA"));
        assertFalse(palindrome.isPalindrome("abBA"));

        assertFalse(palindrome.isPalindrome("abBA",new OffByOne()));
        assertFalse(palindrome.isPalindrome("aa",new OffByOne()));


    }


}
