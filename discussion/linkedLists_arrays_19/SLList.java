public class SLList {
	private class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int item, IntNode next) {
			this.item = item;
			this.next = next;
		}
	}

	private IntNode first;

	public void addFirst(int x) {
		first = new IntNode(x, first);
	}

	/**
	 * inserts x at the given position. 
	 * If position is after the end of the list, 
	 * insert the new node at the end.*/
	 public void insert(int item, int position) {
	 	/*IntNode find = first;
	 	int a = 0;
	 	while(find.next != null){
	 		if(a == (position - 1)){//在前一位停下来
	 			find.next = new IntNode(item,find.next);//插入新元素
	 			break;
	 		}
	 		find = find.next;
	 		a++;
	 	}
	 	if(a < position){//说明要在队尾插入
	 		find.next = new IntNode(item, null);
	 	}*/

	 	if(first == null || position == 0){//处理特殊情况
	 		addFirst(item);
	 		return;
	 	}
	 	IntNode currentNode = first;
	 	while(position > 1 && currentNode.next != 0){//在前一个位置，或者尾部停下来
	 		position--;
	 		currentNode = currentNode.next;
	 	}
	 	IntNode newNode = new IntNode(item, currentNode.next);
	 	currentNode.next = newNode;

	 }

	 /**
	  * Add another method to the SLList class 
	  * that reverses the elements. 
	  * Do this using the existing IntNode objects 
	  * (you should not use new)*/
	  public void reverse() {
	  	/*IntNode p1 = first;
	  	IntNode p2 = first;
	  	int size = 0;
	  	while(p1 != null && p1.next != null){//拿到链表大小
	  		size++;
	  		p1 = p1.next;
	  	}
	  	for(int i = 0; i < size - 1; i++){//用冒泡的方法两两交换，只需要
	  		for(int j = 0; j < size - 1 - i; j++){
	  			int temp = p2.item + p2.next.item;//前后交换
	  			p2.item = temp - p2.item;
	  			p2.next.item = temp - p2.next.item;
	  			p2 = p2.next;//指针向后移动
	  		}
	  		p2 = first;//排完一轮把指针重新指向头部
	  	}*/

	  	//遍历的方式
	  	if(first == null || first.next == null){//排除特殊情况
	  		return;
	  	}
	  	IntNode ptr = first.next;
	  	first.next = null;
	  	while(ptr != null){
	  		IntNode temp = ptr.next;//保存下一个位置
	  		ptr.next = first;//倒转指针指向前一位

	  		first = ptr;//下一轮前，把首指针往后拨
	  		ptr = temp;//变换指针到下一个
	  	}

	  	//递归的方式，需要另一个方法帮助  	
	  }

	  /**
	   * 使用递归方法反转链表*/
	   public void reverseRecur(){
	   	first = reverseHelper(first);
	   }
	  private IntNode reverseHelper(IntNode lst){
	  	if(lst == null || lst,next == null){
	  		return lst;
	  	} else {
	  		IntNode endOfReversed = lst.next;
	  		IntNode reversed = reverseHelper(lst.next);
	  		endOfReversed.next =lst;
	  		lst.next = null;
	  		return reversed;
	  	}
	  }
}