public class Palindrome {
    /**
     * 将word按顺序转为Deque
     * @param word
     * @return
     */
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new ArrayDeque<>();
        char[] arrayChar = word.toCharArray();
        for (int i = 0; i < arrayChar.length; i++) {
            deque.addLast(arrayChar[i]);
        }
        return deque;
    }

    /**
     * 判断字符是否是回文
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        int size = deque.size();
        for (int i = 0; i < size / 2; i++) { // 遍历一般的数组即可
            if (deque.get(i) != deque.get(size - 1 - i)) {
                //取对称位置进行比较，这里会直接转为char来进行对比，否则最好用equals
                return false;
            }
        }
       return true;
    }

    /**
     * 使用比较器，判断word是不是符合比较的回文数
     * @param word
     * @param cc
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        int size = deque.size();
        for (int i = 0; i < size / 2; i++) {
            if(! cc.equalChars(deque.get(i),deque.get(size-1-i))) {
                return false;
            }
        }
        return true;
    }
}
