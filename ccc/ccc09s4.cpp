#include <bits/stdc++.h>
#define min(x, y) (x < y ? x : y);
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
using namespace std;
const int MAXN = 5001, INF = 999999999;
bool vis[MAXN];
int n, m, adj[MAXN][MAXN] = { 0 }, dis[MAXN], p[MAXN], k, d;

void dijkstra(int v) {
	fill(dis, dis + MAXN, INF);
	fill(vis, vis + MAXN, false);
	dis[v] = 0;
	int u;
	while (true) {
		int x = INF;
		u = -1;
		for (int i = 1; i <= n; i++) {
			if (!vis[i] && x >= dis[i]) {
				x = dis[i];
				u = i;
			}
		}
		if (u == -1) break;
		vis[u] = true;
		for (int i = 1; i <= n; i++) {
			if (adj[u][i] != 0) {
				if (dis[i] > x + adj[u][i]) 
					dis[i] = x + adj[u][i];
			}
		}
	}
	return;
}

int main() {
	scan(n); scan(m);
	fill(p, p + MAXN, INF);
	for (int i = 0, x, y, z; i < m; i++) {
		scan(x); scan(y); scan(z);
		if (adj[x][y] != 0) { 
			adj[x][y] = min(z, adj[x][y]); 
			adj[y][x] = adj[x][y];
		}
		else {
			adj[x][y] = z;
			adj[y][x] = z;
		}
	}
	scan(k);
	for (int i = 0, x, y; i < k; i++) {
		scan(x); scan(y);
		p[x] = y;
	}
	scan(d);
	dijkstra(d);
	int min = INF;
	for (int i = 1; i <= n; i++) {
		if (p[i] + dis[i] < min) min = p[i] + dis[i];
	}
	printf("%d\n", min);
	return 0;
}
