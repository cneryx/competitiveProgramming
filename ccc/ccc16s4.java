import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ccc16s4 {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int dp[][] = new int[n + 2][n + 2];
		int sum[] = new int[n + 2];
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], -1);
			dp[i][i] = scanner.nextInt();
			ans = Math.max(ans, dp[i][i]);
			sum[i] = sum[i - 1] + dp[i][i];
		}
		for (int gap = 1; gap <= n; gap++) {
			for (int l = 1; l + gap <= n; l++) {
				int r = l + gap;
				for (int i = l, j = r; i + 1 <= j;) {
					if (dp[l][i] != -1 && dp[j][r] != -1 && dp[l][i] == dp[j][r]) {
						if ((i + 1 == j) || (dp[i + 1][j - 1] != -1)) {
							dp[l][r] = Math.max(dp[l][r], sum[r] - sum[l - 1]);
						}
					}
					if (sum[i] - sum[l - 1] < sum[r] - sum[j - 1])
						i++;
					else
						j--;
				}
				ans = Math.max(ans, dp[l][r]);
			}
		}
		System.out.println(ans);

	}

}
