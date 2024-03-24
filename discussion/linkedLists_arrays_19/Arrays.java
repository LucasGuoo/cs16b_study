public class Arrays{
	private int[] arr;
	private int size;
	Arrays(){
		arr = new int[100];
		size = 0;
	}
	public void add(int item){
		arr[size] = item;
		size++;
	}

	

	/** inserts an int item into an int[] arr at the given position.
	 * The method should return the resulting array.
	 * If position is past the end of the array, 
	 * insert item at the end of the array.*/
	public static int[] insert(int[] arr, int item, int position){
		int newArr = new int[arr.length + 1];
		postition = Math.min(arr.length, postition);//找到真实插入的位置
		for(int = 0; i < position; i++){
			newArr[i] = arr[i];
		}
		result[position] = item;
		for(int i = position; i < arr.length; i++){//如果是插入队尾则不会执行
			newArr[i + 1] = arr[i];
		}
		return newArr;
	}

	/** destructively reverses the items in arr*/
	public static void reverse(int[] arr){
		if(size == 0){//排除特例
			return;
		}
		for(int i = 0; i < (int)(size / 2); i++){//根据索引，将对称位置元素相互
			int temp = arr[i];
			int arr[i] =  arr[size - i];
			int arr[size - i] = temp;
		}
	}

	/**Write a non-destructive method replicate(int[] arr) that replaces the
number at index i with arr[i] copies of itself. For example, replicate([3, 2,
1]) would return [3, 3, 3, 2, 2, 1]. For this question assume that all elements
of the array are positive*/

	public  static int[] extend(int[] arr,int capacity){//数组扩容
		int[] res = new int[capacity];
		System.arraycopy(arr,0,res,0,arr.length);
		return res; 
	}

	public static int[] replicate(int[] arr){

		/*int newArr = new int[arr.length];
		int size = 0;
		for(int i = 0; i < arr.length; i++){//外层遍历arr数组
			for(int j = 0; j < arr[i]; j++){//内层按arr[i]次数存入新数组
				if(size == newArr.lenth){//超出数组则扩容两倍
					newArr.extend(newArr, newArr.lenth * 2);
				}
				newArr[size] = arr[i];
				size++;
			}
		}
		return newArr;*/

		int total = 0;
		for(int item : arr){//遍历一次，得到新数组的长度，省去扩容
			total += item;
		}
		int[] result = new int[total];
		int i = 0;
		for(int item : arr){//再逐个加入
			for(int counter = 0; counter < item; counter++){
				result[i] = item;
				i++;
			}
		}
		return result;
	}
} 