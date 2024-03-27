import java.util.StringJoiner;

public class LinkedListDeque<T> {

  private  Node sentinel;

  private int size;

    /**
     * 封装成员内部类，保护原始数据
     *
     */
    private  class Node{
        public T item;
        public Node previous;
        private Node next;

        Node(T item, Node previous, Node next){
          this.item = item;
          this.previous = previous;
          this.next = next;
        }
    }

    /**
     * 初始化一个空的双端链表
     */
    public LinkedListDeque(){
        sentinel = new Node(null,null,null);//初始化一个头尾相连的哨兵节点,哨兵节点的值为null方便get方法
        sentinel.next = sentinel;//让哨兵首尾相连
        sentinel.previous = sentinel;
        getResult = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
//        if(isEmpty()) {
//            linkToCircle(item);
//        }
      Node head = sentinel.next;
      Node addItem = new Node(item, sentinel,head);
      head.previous = addItem;
      sentinel.next = addItem;
      size++;
    }

//   方法废除：初始化哨兵时就让其首位相连，免去在具体方法中相连
//    /**
//     * 加入第一个元素时，将首尾相连形成循环链表
//     * @param item
//     */
//    private void linkToCircle(T item){
//        Node first = new Node(item,sentinal,sentinal);
//        sentinal.next = first;
//        sentinal.previous = first;
//        size++;
//    }


    public void addLast(T item) {
        Node last = sentinel.previous;
        Node addItem = new Node(item, last, sentinel);
        last.next = addItem;
        sentinel.previous = addItem;
    }

    public boolean isEmpty() {
        return sentinel.next == sentinel; //如果哨兵自连接则说明为空
    }

    public int size() {
        return size;
    }

    /**
     * 从头到尾打印链表的内容，用空格分开
     */
    public void printDeque() {
        Node result = sentinel.next;
        StringJoiner stringJoiner = new StringJoiner(" ");//用空格拼接字符串数组
        while( result != sentinel){
            stringJoiner.add(result.item.toString());
            result = result.next;
        }
        System.out.println(stringJoiner);
    }


    public T removeFirst() {
        if(isEmpty()) {//如果为空则返回空值
            return null;
        }
        //解绑第一个节点
        Node first = sentinel.next;
        Node second = first.next;
        first.next = null;
        first.previous = null;
        T removeItem = (T)first.item;
        first.item = null;
        size--;
        //继续链接
        sentinel.next = second;
        second.previous = sentinel;
        return removeItem;
    }

    public T removeLast() {
        if(isEmpty()) {//如果为空则返回空值
            return null;
        }
        Node remove = sentinel.previous;
        Node last = remove.previous;
        remove.previous = null;
        remove.next = null;
        T removeItem = (T)remove.item;
        size--;

        last.next = sentinel;
        sentinel.previous = last;
        return removeItem;
    }

    /**
     * 获得索引位置的值(0 ~ size-1），不存在则返回null
     * @param index
     * @return
     */
    public T get(int index){
        if(index < 0){//排除负值的情况
            return null;
        }
        Node result = sentinel.next;
        while ( result != sentinel && index > 0 ) {
            result = result.next;
            index--;
        }
        return  (T)result.item;
    }

    /**
     * this pointer is for getRecursive method
     */
    private Node getResult ;

    /**
     *get the item of index using recursion
     */
    public  T getRecursive(int index) {
        if( index < 0){
            T result = (T)getResult.item;
            getResult = sentinel;//取到后应该把指针复原
            return result;
        }
        getResult = getResult.next;
        index--;
        return getRecursive(index);
    }
}
