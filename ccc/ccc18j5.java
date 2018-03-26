import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ccc18j5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m;
		ArrayList[] adj = new ArrayList[n + 1];
		boolean vis[] = new boolean[n + 1];
		StringTokenizer st;
		int[] d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList();
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		d[1] = 1;
		int minDepth = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int v = q.poll();
			vis[v] = true;
			for (int i = 0; i < adj[v].size(); i++) {
				if (!vis[(int) adj[v].get(i)] && d[(int) adj[v].get(i)] == 0) {
					d[(int) adj[v].get(i)] = d[v] + 1;
					q.add((Integer) adj[v].get(i));
				}
			}
			if (adj[v].isEmpty()) {
				minDepth = Math.min(minDepth, d[v]);
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				System.out.println("N");
				break;
			}
			if (i == n) {
				System.out.println("Y");
			}
		}
		System.out.println(minDepth);
	}

}
