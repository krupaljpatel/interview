package kp.dp;

public class LCS {
	int X[][] = new int[10][10];

	public static void main(String args[]) {
		LCS l = new LCS();
		l.findLCS("AGGTAB".toCharArray(), "GXTXAYB".toCharArray(), 6, 7);
		System.out.println(l.X[5][6]);
	}

	public void findLCS(char strr[], char strl[], int m, int n) {

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 | j == 0) {
					X[i][j] = 0;
				} else if (strr[i - 1] == strl[j - 1]) {
					X[i][j] = X[i - 1][j - 1] + 1;
				} else {
					X[i][j] = Math.max(X[i - 1][j], X[i][j - 1]);
				}
			}
		}
	}
}