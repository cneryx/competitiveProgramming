
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class m5ccc18s2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int g[] = new int[n];
		String input[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			g[i] = Integer.parseInt(input[i]);
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if(g[j] < g[j+1]) {
					int temp = g[j];
					g[j] = g[j+1];
					g[j+1] = temp;
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
