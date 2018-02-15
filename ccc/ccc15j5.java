import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc15j5 {
	static int max;
	static int dp[][][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		dp = new int[n + 1][n + 1][k + 1];
		if (n == k) {
			System.out.println(1);
		} else {
			System.out.println(ways(1, n, k));
		}
	}

	static int ways(int p, int n, int k) {
		if (dp[p][n][k] != 0)
			return dp[p][n][k];
		if (k == 1)
			return dp[p][n][k] = 1;
		for (int i = p; i <= n / k; i++) {
			dp[p][n][k] += ways(i, n - i, k - 1);
		}
		return dp[p][n][k];
	}

}
