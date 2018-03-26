import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ccc09s3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int[][] graph = new int[50][50];
		int[] dis = new int[50];
		boolean[] vis;
		graph[1][6] = 1;
		graph[6][1] = 1;
		graph[2][6] = 1;
		graph[6][2] = 1;
		graph[3][6] = 1;
		graph[6][3] = 1;
		graph[4][6] = 1;
		graph[6][4] = 1;
		graph[5][6] = 1;
		graph[6][5] = 1;
		graph[7][6] = 1;
		graph[6][7] = 1;
		graph[3][4] = 1;
		graph[4][3] = 1;
		graph[4][5] = 1;
		graph[5][4] = 1;
		graph[3][5] = 1;
		graph[5][3] = 1;
		graph[3][15] = 1;
		graph[15][3] = 1;
		graph[13][15] = 1;
		graph[15][13] = 1;
		graph[14][13] = 1;
		graph[13][14] = 1;
		graph[12][13] = 1;
		graph[13][12] = 1;
		graph[7][8] = 1;
		graph[8][7] = 1;
		graph[8][9] = 1;
		graph[9][8] = 1;
		graph[9][10] = 1;
		graph[10][9] = 1;
		graph[9][12] = 1;
		graph[12][9] = 1;
		graph[10][11] = 1;
		graph[11][10] = 1;
		graph[11][12] = 1;
		graph[12][11] = 1;
		graph[16][17] = 1;
		graph[17][16] = 1;
		graph[16][18] = 1;
		graph[18][16] = 1;
		graph[18][17] = 1;
		graph[17][18] = 1;
		String command = "z";
		while (!command.equals("q")) {
			int x;
			int y;
			int count = 0;
			switch (command) {
			case "i":
				x = Integer.valueOf(scanner.next());
				y = Integer.valueOf(scanner.next());
				graph[x][y] = 1;
				graph[y][x] = 1;
				break;
			case "d":
				x = Integer.valueOf(scanner.next());
				y = Integer.valueOf(scanner.next());
				graph[x][y] = 0;
				graph[y][x] = 0;
				break;
			case "n":
				x = Integer.valueOf(scanner.next());
				for (int i = 0; i < 50; i++) {
					if (graph[x][i] == 1) {
						count++;
					}
				}
				System.out.println(count);
				break;
			case "f":
				x = Integer.valueOf(scanner.next());
				vis = new boolean[50];
				for (int i = 0; i < 50; i++) {
					if (graph[x][i] == 1) {
						for (int j = 0; j < 50; j++) {
							if (graph[i][j] == 1 && j != x && graph[j][x] != 1 && !vis[j]) {
								count++;
								vis[j] = true;
							}
						}
					}
				}
				System.out.println(count);
				break;
			case "s":
				x = Integer.parseInt(scanner.next());
				y = Integer.parseInt(scanner.next());
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(x);
				dis = new int[50];
				vis = new boolean[50];
				vis[x] = true;
				Arrays.fill(dis, Integer.MAX_VALUE);
				dis[x] = 0;
				while (!q.isEmpty() && dis[y] == Integer.MAX_VALUE) {
					int v = q.poll();
					for (int i = 0; i < 50; i++) {
						if (graph[v][i] == 1 && !vis[i]) {
							q.add(i);
							vis[i] = true;
							dis[i] = dis[v] + 1;
						}
					}
				}
				if (dis[y] != Integer.MAX_VALUE)
					System.out.println(dis[y]);
				else
					System.out.println("Not connected");
				break;
			}
			command = scanner.next();
		}
		scanner.close();

	}

}
