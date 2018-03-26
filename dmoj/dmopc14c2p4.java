import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dmopc14c2p4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0)
				sum[i] = Integer.parseInt(br.readLine());
			else
				sum[i] = Integer.parseInt(br.readLine()) + sum[i - 1];
		}
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			if (x == 0)
				System.out.println(sum[y]);
			else
				System.out.println(sum[y] - sum[x - 1]);
		}
	}

}
