package algcode.zuo.topic.matrix;

public class C_ZigZagPrintMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println("之字形打印矩阵后为：");
		printMatrixZigZag(matrix);
	}

	/**
	 * 之字形打印矩阵
	 */
	public static void printMatrixZigZag(int[][] matrix) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int enc = matrix.length - 1;
		int end = matrix[0].length - 1;
		boolean fromUp = false;
		while (a != enc + 1) {
			printLevel(matrix, a, b, c, d, fromUp);
			a = b == end ? a + 1 : a;
			b = b == end ? b : b + 1;
			d = c == enc ? d + 1 : d;
			c = c == enc ? c : c + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int a, int b, int c, int d, boolean f) {
		if (f) {
			while (a != c + 1) {
				System.out.print(m[a++][b--] + " ");
			}
		} else {
			while (c != a - 1) {
				System.out.print(m[c--][d++] + " ");
			}
		}
	}
}
