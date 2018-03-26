import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc12s5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int r = Integer.parseInt(temp[0]);
		int c = Integer.parseInt(temp[1]);
		int k = Integer.parseInt(br.readLine());
		int[][] cats = new int[r + 1][c + 1];
		int[][] dp = new int[r + 1][c + 1];
		for (int i = 0; i < k; i++) {
			temp = br.readLine().split(" ");
			cats[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 1;
		}
		dp[1][1] = 1;
		cats[1][1] = 1;
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (cats[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		System.out.println(dp[r][c]);
	}

}
