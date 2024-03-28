
import java.util.StringJoiner;

public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final double FACTOR = 0.5;

    public double getFACTOR() {
        return FACTOR;
    }

    public int getNextFirst() {
        return nextFirst;
    }

    public int getNextLast() {
        return nextLast;
    }

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(Item item) {
        if (size == items.length) { //超出则变为150%
            changeSize((int) (items.length * (1 + FACTOR)));
        }
        if (nextFirst == -1) { //先判断边界，需要往尾部继续插入
            nextFirst = items.length + nextFirst;
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
    }
    @Override
    public void addLast(Item item) {
        if (size == items.length) { //超出则变为150%
            changeSize((int) (items.length * (1 + FACTOR)));
        }
        if (nextLast == items.length) { //需要先判断是否超出边界，是则放在队首
            nextLast = 0;
        }
        items[nextLast] = item;
        nextLast++;
        size++;

    }

    /**
     * 根据具体容量来对数组大小进行更改
     * @param capacity
     * @return
     */
    private Item[] changeSize(int capacity) {
        Item[] newItems = (Item[]) new Object[capacity]; //创建具体大小的数组
        for(int i = 0, current = nextFirst + 1; i < size; i++,current++) { //按顺序倒入新数组
            if(current == items.length) {
                current = 0;
            }
            newItems[i] = items[current];
        }
        nextFirst = capacity - 1;
        nextLast = size;
         items = newItems;
         return items;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Item removeFirst() {
        if(size == 0){ //空则返回null
            return null;
        }
        if (size < items.length * FACTOR) { //使用率低于50%则调整大小变为原来的75%
            changeSize((int) (items.length * 4 * FACTOR / 3));
        }
        if(nextFirst == items.length - 1) { //特殊情况将指针拨回0
            Item removeItem = items[0];
            items[0] = null;
            nextFirst = 0;
            size--;
            return removeItem;
        }
        Item removeItem = items[nextFirst + 1]; //常规移除
        items[nextFirst + 1] = null;
        nextFirst++;
        size--;
        return removeItem;
    }

    @Override
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        if (size < items.length * FACTOR) { //使用率低于50%则调整大小变为原来的75%
            changeSize((int) (items.length * 4 * FACTOR / 3));
        }
        if(nextLast == 0) { //特例将指针从头拨到尾部
            Item removeItem = items[items.length - 1];
            items[items.length - 1] = null;
            nextLast = items.length - 1;
            size--;
            return removeItem;
        }
        Item removeItem = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast--;
        size--;
        return removeItem;
    }

    @Override
    public void printDeque() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        for(int i = 0,current = nextFirst + 1; i < size; i++, current++) { //循环size遍出去item
            if(current == items.length ) { //如果索引为长度，则说明下一个在头部
                current = 0;
            }
            stringJoiner.add(items[current].toString());
        }
        System.out.println(stringJoiner);
    }


    /**
     * 根据索引取值
     * @param index
     * @return
     */
    @Override
    public Item get(int index) {
        if (index >= 0 && index < size ) {
            int result ;
            if (nextFirst < nextLast && size != items.length) {
                //头在尾前面，正常取,需要排除满数组的情况，否则会空指针异常！！！
                result = nextFirst + 1 + index;
            } else { //头在尾后面，以及满数组的情况
                if (index < (items.length - nextFirst -1)) { //不需要回到头部
                    result = nextFirst + 1 + index;
                } else {
                    result = index - (items.length - nextFirst -1); //从头开始取，以及满数组的情况
                }
            }
            return items[result];
        }
        return null;
    }

}
