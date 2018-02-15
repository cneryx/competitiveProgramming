import java.util.Scanner;

public class SimonAndMarcy {

	static int c;
	static int m;
	static int dp[];

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		c = scanner.nextInt();
		m = scanner.nextInt();
		dp = new int[m + 1];
		for (int i = 1; i <= c; i++) {
			int v = scanner.nextInt(), w = scanner.nextInt();
			for (int j = m; j >= w; j--) {
				dp[j] = Math.max(dp[j], v + dp[j - w]);
			}
		}

		System.out.println(dp[m]);

	}

}
