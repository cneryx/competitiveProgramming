
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class m5ccc18s3 {

	static ArrayList[] adj;
	static boolean vis[];
	static int n;
	static boolean c;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		int edges[][] = new int[m][2];
		vis = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			temp = br.readLine().split(" ");
			adj[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
			edges[i][0] = Integer.parseInt(temp[0]);
			edges[i][1] = Integer.parseInt(temp[1]);
		}
		for (int i = 0; i < m; i++) {
			adj[edges[i][0]].remove(Integer.valueOf(edges[i][1]));
			vis = new boolean[n];
			c = false;
			dfs(1);
			adj[edges[i][0]].add(Integer.valueOf(edges[i][1]));
			if (c) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	static void dfs(int v) {
		vis[v] = true;
		for (int i = 0; i < adj[v].size(); i++) {
			if (adj[v].get(i).equals(Integer.valueOf(n))) {
				c = true;
				return;
			}
			if (!vis[(int) adj[v].get(i)]) {
				vis[(int) adj[v].get(i)] = true;
				dfs((int) adj[v].get(i));
				if (c)
					return;
			}
		}
		return;
	}

}
