import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc17s1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		int sum1 = 0;
		int sum2 = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			sum1 += Integer.parseInt(s1[i]);
			sum2 += Integer.parseInt(s2[i]);
			if (sum1 == sum2) {
				max = i + 1;
			}
		}
		System.out.println(max);
	}

}
