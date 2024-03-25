

public class IntList {
    private int first;
    private  IntList rest;
    IntList(int item){
        first = item;
        rest = null;
    }
    IntList(int item, IntList rest){
        first = item;
        this.rest = rest;
    }

    /**
     * 重写equals方法才能让测试中的assertEquals正确执行
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        IntList s = (IntList) obj;
        IntList p = this;
        while(s.rest != null && p.rest != null){//比较内容
            if(s.first != p.first){
                return false;
            }
            s = s.rest;
            p = p.rest;
        }
        if(s.rest != null || p.rest != null){//避免长度不同
            return false;
        }

        return true;
    }

    /**
     * 用未知参数接受任意个元素，形成链表
     * @param args
     * @return
     */
    public static IntList list(int... args){
        IntList L = new IntList(args[args.length - 1]);
        for(int i = args.length - 2; i >= 0; i--){//需要倒过来生成链表
            L = new IntList(args[i],L);
        }
        return L;
    }

    /**
     * Suppose we have the following IntList class, as defined in lecture and lab, with an
     * added skippify function.
     * Suppose that we define two IntLists as follows.
     * 1 IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
     * 2 IntList B = IntList.list(9, 8, 7, 6, 5, 4, 3, 2, 1);
     * Fill in the method skippify such that the result of calling skippify on A and B
     * are as below:
     * - After calling A.skippify(), A: (1, 3, 6, 10)
     * - After calling B.skippify(), B: (9, 7, 4)
     * @return
     */
   public void skippify() {
       IntList p = this;
       int n = 1;
       while (p != null) {
           IntList next = p.rest;
           for(int i = 0; i < n; i++) {//根据步长循环
               if(next == null) {
                   break;
               }
               next = next.rest;
           }
           p.rest = next;//链接下一个节点
           p = next;
           n++;//增加步长
       }
    }

    /**
     * Given a sorted linked list of items - remove duplicates.
     * For example given 1 -> 2 -> 2 -> 2 -> 3,
     * Mutate it to become 1 -> 2 -> 3 (destructively)
     */

    public static void removeDuplicates(IntList p) {
        if(p == null) {
            return;
        }
        IntList current = p.rest;
        IntList previous = p;
        while (current != null) {
            if(previous.first == current.first) {
                current = current.rest;
                previous.rest = current;
            } else {
                previous = current;
                current = current.rest;
            }
        }

    }
}
