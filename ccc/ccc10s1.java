
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc10s1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int v = 2 * r + 3 * s + d;
			String b1 = name;
			String b2 = "";
			int max = v;
			int max2 = 0;
			for (int i = 1; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				name = st.nextToken();
				r = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				v = 2 * r + 3 * s + d;
				if (v > max || (v == max && name.compareTo(b1) < 0)) {

					max2 = max;
					max = v;
					b2 = b1;
					b1 = name;
				} else if (v > max2 || (v == max2 && name.compareTo(b2) < 0)) {
					max2 = v;
					b2 = name;
				}
			}
			if (n == 1) {
				System.out.println(b1);
			} else {
				System.out.println(b1);
				System.out.println(b2);
			}
		}

	}

}
