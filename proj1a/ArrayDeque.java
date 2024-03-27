import java.util.StringJoiner;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final double FACTOR = 0.5;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T item) {
        if (size == items.length) { //超出则变为150%
            changeSize((int) (items.length * (1 + FACTOR)));
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
        if (nextFirst < 0) { //双端数组，需要往尾部继续插入
            nextFirst = items.length + nextFirst;
        }
    }

    public void addLast(T item) {
        if (size == items.length) { //超出则变为150%
            changeSize((int) (items.length * (1 + FACTOR)));
        }
        items[nextLast] = item;
        nextLast++;
        size++;
        if (nextLast > items.length) { //超出边界则下一个自动放在队首
            nextLast = 0;
        }
    }

    /**
     * 根据具体容量来对数组大小进行更改
     * @param capacity
     * @return
     */
    private T[] changeSize(int capacity) {
        T[] newItems = (T[]) new Object[capacity]; //创建具体大小的数组
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



    public boolean isEmpty() {
        return size == 0;
    }

    public T removeFirst() {
        if(size == 0){ //空则返回null
            return null;
        }
        if (size < items.length * FACTOR) { //使用率低于50%则调整大小变为原来的75%
            changeSize((int) (items.length * 4 * FACTOR / 3));
        }
        if(nextFirst == items.length - 1) { //特殊情况将指针拨回0
            T removeItem = items[0];
            items[0] = null;
            nextFirst = 0;
            size--;
            return removeItem;
        }
        T removeItem = items[nextFirst + 1]; //常规移除
        items[nextFirst + 1] = null;
        nextFirst++;
        size--;
        return removeItem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size < items.length * FACTOR) { //使用率低于50%则调整大小变为原来的75%
            changeSize((int) (items.length * 4 * FACTOR / 3));
        }
        if(nextLast == 0) { //特例将指针从头拨到尾部
            T removeItem = items[items.length - 1];
            items[items.length - 1] = null;
            nextLast = items.length - 1;
            size--;
            return removeItem;
        }
        T removeItem = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast--;
        size--;
        return removeItem;
    }


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
}
