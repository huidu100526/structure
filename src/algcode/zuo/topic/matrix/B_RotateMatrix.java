package algcode.zuo.topic.matrix;

public class B_RotateMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		System.out.println("矩阵顺时针旋转前：");
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("矩阵顺时针旋转后：");
		printMatrix(matrix);
	}

	/**
	 * 将正方形矩阵顺时针旋转90度
	 * a,b,c,d 四个点为矩阵四个顶点
	 * while (a < c)
	 * 	   一次旋转一圈，条件为当顶点相等时结束
	 * for (int i = 0; i != times; i++)
	 * 	   一次调整一个点，与邻边的点交换即可，只需调整一行的个数减一
	 */
	public static void rotate(int[][] matrix) {
		int a = 0;
		int b = 0;
		int c = matrix.length - 1;
		int d = matrix[0].length - 1;
		while (a < c) {
			rotateEdge(matrix, a++, b++, c--, d--);
		}
	}

	public static void rotateEdge(int[][] m, int a, int b, int c, int d) {
		int times = d - b;
		int tmp = 0;
		for (int i = 0; i != times; i++) {
			tmp = m[a][b + i];
			m[a][b + i] = m[c - i][b];
			m[c - i][b] = m[c][d - i];
			m[c][d - i] = m[a + i][d];
			m[a + i][d] = tmp;
		}
	}

	public static void printMatrix(int[][] maaix) {
		for (int i = 0; i != maaix.length; i++) {
			for (int j = 0; j != maaix[0].length; j++) {
				System.out.print(maaix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
