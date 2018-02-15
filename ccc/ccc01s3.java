
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ccc01s3 {

	static int[][] adj = new int[26][26];
	static int[] visited;
	static ArrayList<String> list = new ArrayList<String>();
	static int n;
	static boolean c;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int count = 0;

		while (s != null) {
			if (s.equals("**")) {
				break;
			}
			adj[s.charAt(0) - 'A'][s.charAt(1) - 'A'] = 1;
			adj[s.charAt(1) - 'A'][s.charAt(0) - 'A'] = 1;
			list.add(s);
			s = br.readLine();
		}
		for (int i = 0; i < 26; i++) {
			for (int j = i + 1; j < 26; j++) {
				if (adj[i][j] == 1) {
					visited = new int[26];
					adj[i][j] = 0;
					adj[j][i] = 0;
					visited[0] = 1;
					DFS(0, visited);
					adj[i][j] = 1;
					adj[j][i] = 1;
					if (!c) {
						// System.out.println(i +" " + j);
						for (int k = 0; k < list.size(); k++) {
							int a = list.get(k).charAt(0) - 'A';
							int b = list.get(k).charAt(1) - 'A';
							if ((i == b && j == a) || (j == b && i == a)) {
								System.out.println(list.get(k));
								count++;
							}
						}
					}
					c = false;
				}
			}
		}
		System.out.println("There are " + count + " disconnecting roads.");

	}

	static void DFS(int v, int[] vis) {
		for (int i = 0; i < 26; i++) {
			if (adj[v][i] == 1 && vis[i] == 0) {
				if (i == 1) {
					c = true;
					return;
				}
				vis[i] = 1;
				DFS(i, vis);
				if (c == true) {
					return;
				}
			}
		}
		return;
	}

}
