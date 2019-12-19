package algcode.zuo.topic.matrix;

public class A_PrintMatrixSpiralOrder {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		System.out.println("矩阵顺时针打印元素：");
		spiralOrderPrint(matrix);
	}

	/**
	 * 转圈打印矩阵，额外空间复杂度为O(1)
	 * a,b,c,d 四个点为矩阵四个顶点
	 * while (a <= c && b <= d)
	 * 	   一次打印一圈，条件为当左上角的点不越过右下角的点
	 */
	public static void spiralOrderPrint(int[][] matrix) {
		int a = 0;
		int b = 0;
		int c = matrix.length;
		int d = matrix[0].length;
		while (a <= c && b <= d) {
		    printEdge(matrix, a++, b++, c--, d--);
        }
	}

	public static void printEdge(int[][] m, int a, int b, int c, int d) {
		if (a == c) { // 当矩阵只有一行
			for (int i = b; i <= d; i++) {
				System.out.print(m[a][i] + " ");
			}
		} else if (b == d) { // 当矩阵只有一列
			for (int i = a; i <= c; i++) {
				System.out.print(m[i][b] + " ");
			}
		} else {
			int curC = b;
			int curl = a;
			while (curC != d) {
				System.out.print(m[a][curC] + " ");
				curC++;
			}
			while (curl != c) {
				System.out.print(m[curl][d] + " ");
				curl++;
			}
			while (curC != b) {
				System.out.print(m[c][curC] + " ");
				curC--;
			}
			while (curl != a) {
				System.out.print(m[curl][b] + " ");
				curl--;
			}
		}
	}
}
