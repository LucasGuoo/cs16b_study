
public class Flatten{

	/**Write a method flatten that takes in a 2-D array x and returns a 1-D array that
contains all of the arrays in x concatenated together.
For example, flatten({{1, 2, 3}, {}, {7, 8}}) should return {1, 2, 3, 7, 8}.*/
	
	public static int[] flatten(int[][] x){
		int totalLength = 0;
		for(int i = 0; i < x.length; i++){//得出元素个数
			totalLength += x[i].length;
		}
		int[] a = new int[totalLength];
		int aIndex = 0;
		for(int i = 0; i < x.length; i++){//放入元素
			for(int j = 0; j < x[i].length; j++){
				a[aIndex++] = x[i][j];
			}
		}
		return a;
	}

}