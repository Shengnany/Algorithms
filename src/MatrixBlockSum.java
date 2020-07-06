//1314. Matrix Block Sum *Backtracking
//
//        Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.
//
//        Example 1:
//        Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
//        Output: [[12,21,16],[27,45,33],[24,39,28]]
//        Example 2:
//        Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
//        Output: [[45,45,45],[45,45,45],[45,45,45]]
//
//        Constraints:
//        •	m == mat.length
//        •	n == mat[i].length
//        •	1 <= m, n, K <= 100
//        •	1 <= mat[i][j] <= 100
//
//
//


class MaxBlocKSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m+1][n+1];
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] -
                        sum[r - 1][c - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int r1 = Math.max(0, r - K), c1 = Math.max(0, c - K);
                int r2 = Math.min(m - 1, r + K), c2 = Math.min(n - 1, c + K);
                r1++; c1++; r2++; c2++;
                ans[r][c] = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
            }
        }
        return ans;
    }
}




