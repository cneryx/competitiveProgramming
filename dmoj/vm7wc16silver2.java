import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class vm7wc16silver2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] g = br.readLine().toCharArray();
		int[] in = new int[g.length];
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < g.length; i++) {
			if (g[i] == 'G') {
				in[i]++;
			}
		}
		int[] dp = new int[g.length];
		int cur = 0;
		if (in[0] == 1) {
			dp[0] += 1;
			cur += 1;
		}

		for (int i = 1; i < g.length; i++) {
			if (in[i] == 1)
				cur++;
			dp[i] = cur;
		}
		for (int i = 0; i < q; i++) {
			int x, y;
			String[] temp = br.readLine().split(" ");
			x = Integer.parseInt(temp[0]);
			y = Integer.parseInt(temp[1]);
			if (x == 0) {
				System.out.println(dp[y]);
			} else System.out.println(dp[y]-dp[x-1]);
		}

	}

}
