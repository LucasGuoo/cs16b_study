public class OffByOne implements CharacterComparator{
    /**
     * 如果x和y相差为1，则返回true
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
