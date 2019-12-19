package algcode.zuo.topic.matrix;

public class D_FindNumInSortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{ 0,   1,   2,   3,   4,   5,   6 },
			{ 10,  12,  13,  15,  16,  17,  18 },
			{ 23,  24,  25,  26,  27,  28,  29 },
			{ 44,  45,  46,  47,  48,  49,  50 },
			{ 65,  66,  67,  68,  69,  70,  71 },
			{ 96,  97,  98,  99,  100, 111, 122 },
			{ 166, 176, 186, 187, 190, 195, 200 },
			{ 233, 243, 321, 341, 356, 370, 380 }
		};
		int K = 233;
		System.out.println(isContains(matrix, K));
	}

	/**
	 * 一个矩阵中每一行每一列都是排好序的，怎样最快判断一个数是否在矩阵中
	 * 时间复杂度为O(N+M)，额外空间复杂度为O(1)
	 * 	   从右上角的点开始找，如果这个点的数比 K 小就往下走(行号加一)，如果这个点的数比 K 大就往左走(列数减一)
	 */
	public static boolean isContains(int[][] matrix, int K) {
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col > -1) {
			if (matrix[row][col] == K) {
				return true;
			} else if (matrix[row][col] > K) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}
