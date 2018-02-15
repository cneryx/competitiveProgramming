
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ccc17s2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] a = br.readLine().split(" ");
		int[] h = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(a[i]);
		}
		Arrays.sort(h);
		System.out.println();
		if (n % 2 == 0) {
			int x = (n / 2) - 1;
			System.out.print(h[x] + " ");
			for (int i = 1; i < n / 2; i++) {
				System.out.print(h[x + i] + " ");
				System.out.print(h[x - i] + " ");
			}
			System.out.print(h[n - 1]);
		} else {
			int x = n / 2;
			System.out.print(h[x] + " ");
			for (int i = 1; i <= n / 2; i++) {
				System.out.print(h[x + i] + " ");
				System.out.print(h[x - i] + " ");
			}
		}
	}

}
