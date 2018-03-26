#include <bits/stdc++.h>
using namespace std;
int main() {
	vector<int> adj[2001];
	int n, m, a, b, x, y;
	scanf("%d %d %d %d", &n, &m, &a, &b);
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		adj[x].push_back(y);
		adj[y].push_back(x);
	}
	bool vis[2001] = {false};
	queue<int> q;
	q.push(a);
	int v;
	while (!q.empty()) {
		v = q.front();
		q.pop();
		vis[v] = true;
		if (v == b) {
			printf("GO SHAHIR!\n");
			break;
		}
		for (int i = 1; i <= 2000; i++) {
			if (find(adj[v].begin(), adj[v].end(), i) != adj[v].end() && !vis[i]) {
				q.push(i);
			}
		}
	}
	if (!vis[b]) printf("NO SHAHIR!\n");
	return 0;
}
