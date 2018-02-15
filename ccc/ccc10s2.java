
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ccc10s2 {

	static String[] c, b;
	static int n;
	static ArrayList<String> list = new ArrayList<String>();
	static String ans = "";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		c = new String[n];
		b = new String[n];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			c[i] = temp[0];
			b[i] = temp[1];
		}
		String code = br.readLine();
		String[] temp = code.split("");
		for (int i = 0; i < code.length(); i++) {
			list.add(temp[i]);
		}
		System.out.println(d());
	}

	static String d() {
		String a = "";
		int i = 0;
		while(list.size() != 0) {
			a += list.get(i);
			list.remove(i);
			for (int j = 0; j < n; j++) {
				if (b[j].equals(a)) {
					return c[j] + d();
				}
			}
		}
		return "";
	}

}
