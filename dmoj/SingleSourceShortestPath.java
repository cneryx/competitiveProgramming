
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SingleSourceShortestPath {

	static int n;
	static int[][] adj;
	static int[] dis;
	static boolean[] vis;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int x, y, z;
		dis = new int[n + 1];
		vis = new boolean[n + 1];
		adj = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			temp = br.readLine().split(" ");
			x = Integer.parseInt(temp[0]);
			y = Integer.parseInt(temp[1]);
			z = Integer.parseInt(temp[2]);
			if (adj[x][y] == 0) {
				adj[x][y] = z;
				adj[y][x] = z;
			} else {
				z = Math.min(Integer.parseInt(temp[2]), adj[x][y]);
				adj[x][y] = z;
				adj[y][x] = z;
			}
		}

		dijkstra(1);
		for (int i = 1; i < n + 1; i++) {
			if (dis[i] != Integer.MAX_VALUE) {
				System.out.println(dis[i]);
			} else {
				System.out.println(-1);
			}
		}

	}

	static void dijkstra(int s) {
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[s] = 0;
		int v = 0;
		int min = Integer.MAX_VALUE;
		while (true) {
			min = Integer.MAX_VALUE;
			for (int i = 1; i < n + 1; i++) {
				if (dis[i] < min && !vis[i]) {
					v = i;
					min = dis[i];
				}
			}
			if (vis[v])
				break;
			vis[v] = true;
			for (int i = 0; i < n + 1; i++) {
				if (adj[v][i] != 0 && !vis[i]) {
					int newD = dis[v] + adj[v][i];
					if (newD < dis[i]) {
						dis[i] = newD;
					}
				}
			}
		}

	}

}
