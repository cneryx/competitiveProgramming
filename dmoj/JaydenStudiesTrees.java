
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class JaydenStudiesTrees {

	static int[][] a;
	static int n;
	static int max;
	static int f;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		a = new int[n + 1][n + 1];

		for (int i = 0; i < n - 1; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			a[x][y] = 1;
			a[y][x] = 1;
		}
		f = 0;

		BFS(1);
		max = 0;
		BFS(f);
		System.out.println(max);
	}

	static void BFS(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		int d[] = new int[n + 1];
		int[] visited = new int[n + 1];
		while (!q.isEmpty()) {
			int v = q.poll();
			if (visited[v] == 0) {
				visited[v] = 1;
				for (int j = 1; j < n + 1; j++) {
					if (a[v][j] == 1 && visited[j] == 0) {
						q.add(j);
						d[j] = d[v] + 1;
						f = j;
						max = Math.max(max, d[j]);
					}
				}

			}
		}
	}
}
