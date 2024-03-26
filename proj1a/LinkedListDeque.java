public class LinkedListDeque<T> {

  private  Node sentinal;

  private int size;

    private  class Node<T>{//
        public T item;
        public Node previous;
        private Node next;

        Node(T item, Node previous, Node next){
          this.item = item;
          this.previous = previous;
          this.next = next;
        }
    }
    public LinkedListDeque(){
        sentinal = new Node(null,null,null);//初始化一个头尾相连的哨兵节点,哨兵节点的值为null方便get方法
        sentinal.next = sentinal;//让哨兵首尾相连
        sentinal.previous = sentinal;
        size = 0;
    }

    public void addFirst(T item) {
//        if(isEmpty()) {
//            linkToCircle(item);
//        }
      Node head = sentinal.next;
      Node addItem = new Node(item,sentinal,head);
      head.previous = addItem;
      sentinal.next = addItem;
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

    public static void main(String[] args) {
        LinkedListDeque<Integer> integerLinkedListDeque = new LinkedListDeque<>();

        integerLinkedListDeque.addFirst(1);
        integerLinkedListDeque.addFirst(2);
        integerLinkedListDeque.addLast(3);
        System.out.println(integerLinkedListDeque.get(0));
        System.out.println(integerLinkedListDeque.get(-1));
        System.out.println(integerLinkedListDeque.get(1));
        System.out.println(integerLinkedListDeque.get(3));


    }

    public void addLast(T item) {
        Node last = sentinal.previous;
        Node addItem = new Node(item, last, sentinal);
        last.next = addItem;
        sentinal.previous = addItem;
    }

    public boolean isEmpty() {
        return sentinal.next == sentinal; //如果哨兵自连接则说明为空
    }

    public int size() {
        return size;
    }
    public void printDeque() {

    }

    public T removeFirst() {
        if(isEmpty()) {//如果为空则返回空值
            return null;
        }
        //解绑第一个节点
        Node first = sentinal.next;
        Node second = first.next;
        first.next = null;
        first.previous = null;
        T removeItem = (T)first.item;
        first.item = null;
        //继续链接
        sentinal.next = second;
        second.previous = sentinal;
        return removeItem;
    }

    public T removeLast() {
        if(isEmpty()) {//如果为空则返回空值
            return null;
        }
        Node remove = sentinal.previous;
        Node last = remove.previous;
        remove.previous = null;
        remove.next = null;
        T removeItem = (T)remove.item;

        last.next = sentinal;
        sentinal.previous = last;
        return removeItem;
    }

    /**
     * 获得索引位置的值(0 ~ size-1），不存在则返回null
     * @param index
     * @return
     */
    public T get(int index){
        Node result = sentinal;
        while ( result.next != sentinal || index-- >= 0 ) {
            result = result.next;
        }
        return  (T)result.item;
    }
}
