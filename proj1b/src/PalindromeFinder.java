/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator characterComparator = new OffByN(5); //自定义字符比较器

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word,characterComparator)) {
                //使用自定义字符比较器来筛选字符串
                System.out.println(word);
            }
        }
    }
}
