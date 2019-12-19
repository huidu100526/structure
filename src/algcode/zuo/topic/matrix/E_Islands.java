package algcode.zuo.topic.matrix;

public class E_Islands {
	public static void main(String[] args) {
		int[][] m1 = {
		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 0, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        };
		System.out.println(countIslands(m1));

		int[][] m2 = {
		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        };
		System.out.println(countIslands(m2));
	}

    /**
     * 岛问题
     *     一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右四个位置相连，如果有一片1连在一起，这个部分叫做一个岛
     *     求一个矩阵中有多少个岛？
     */
	public static int countIslands(int[][] matrix) {
		if (matrix == null || matrix[0] == null) {
			return 0;
		}
		int row = matrix.length; // 行
		int col = matrix[0].length; // 列
		int res = 0; // 记录岛数量
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) { // 遍历矩阵，遇到1就进入函数
					res++;
					infect(matrix, i, j, row, col);
				}
			}
		}
		return res;
	}

	public static void infect(int[][] matrix, int i, int j, int row, int col) {
		if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] != 1) {
            return;
        }
        matrix[i][j] = 2;
        infect(matrix, i + 1, j, row, col); // 感染下
        infect(matrix, i - 1, j, row, col); // 感染上
        infect(matrix, i, j + 1, row, col); // 感染右
        infect(matrix, i, j - 1, row, col); // 感染左
	}
}
