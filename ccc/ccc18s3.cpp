#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;
const int INF = 999999999;
int n, m, dis[100][100], f[100][100];
bool e[100][100] = { false };
bool cam[100][100] = { false };

int main() {
	scanf("%d %d\n", &n, &m);
	pii start;
	for (int i = 0; i < n; i++) {
		fill(dis[i], dis[i] + m, INF);
		fill(f[i], f[i] + m, -1);
		char c[100];
		scanf("%s", &c);
		for (int j = 0; j < m; j++) {
			if (c[j] == 'W') {
				f[i][j] = 1;
				cam[i][j] = true;
			}
			else if (c[j] == '.') {
				f[i][j] = 0;
				e[i][j] = true;
			}
			else if (c[j] == 'C') f[i][j] = 2;
			else if (c[j] == 'L') f[i][j] = 3;
			else if (c[j] == 'R') f[i][j] = 4;
			else if (c[j] == 'U') f[i][j] = 5;
			else if (c[j] == 'D') f[i][j] = 6;
			else {
				f[i][j] = 0;
				start = make_pair(i, j);
			}
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (f[i][j] == 2) {
				for (int k = i; k < n; k++) {
					if (!cam[k][j]) {
						if(f[k][j] <= 1)
							f[k][j] = 1;
					}
					else break;
				}
				for (int k = i; k >= 0; k--) {
					if (!cam[k][j]) {
						if (f[k][j] <= 1)
							f[k][j] = 1;
					}
					else break;
				}
				for (int k = j; k < m; k++) {
					if (!cam[i][k]) {
						if (f[i][k] <= 1)
							f[i][k] = 1;
					}
					else break;
				}
				for (int k = j; k >= 0; k--) {
					if (!cam[i][k]) {
						if (f[i][k] <= 1)
							f[i][k] = 1;
					}
					else break;
				}
				f[i][j] = 1;
			}
		}
	}
	if (f[start.first][start.second] == 0) {
		queue<pii> q;
		q.push(start);
		dis[start.first][start.second] = 0;
		while (!q.empty()) {
			pii cur = q.front();
			int d = dis[cur.first][cur.second];
			int u = f[cur.first][cur.second];
			q.pop();
			if (u == 1) continue;
			else if (u == 3) {
				if (f[cur.first][cur.second - 1] >= 3) {
					if (dis[cur.first][cur.second - 1] > d) {
						dis[cur.first][cur.second - 1] = d;
						q.push(make_pair(cur.first, cur.second - 1));
					}
				}
				else if (f[cur.first][cur.second - 1] == 0) {
					if (dis[cur.first][cur.second - 1] > d + 1) {
						dis[cur.first][cur.second - 1] = d + 1;
						q.push(make_pair(cur.first, cur.second - 1));
					}
				}
			}
			else if (u == 4) {
				if (f[cur.first][cur.second + 1] >= 3) {
					if (dis[cur.first][cur.second + 1] > d) {
						dis[cur.first][cur.second + 1] = d;
						q.push(make_pair(cur.first, cur.second + 1));
					}
				}
				else if (f[cur.first][cur.second + 1] == 0) {
					if (dis[cur.first][cur.second + 1] > d + 1) {
						dis[cur.first][cur.second + 1] = d + 1;
						q.push(make_pair(cur.first, cur.second + 1));
					}
				}
			}
			else if (u == 5) {
				if (f[cur.first - 1][cur.second] >= 3) {
					if (dis[cur.first - 1][cur.second] > d) {
						dis[cur.first - 1][cur.second] = d;
						q.push(make_pair(cur.first - 1, cur.second));
					}
				}
				else if (f[cur.first - 1][cur.second] == 0) {
					if (dis[cur.first - 1][cur.second] > d + 1) {
						dis[cur.first - 1][cur.second] = d + 1;
						q.push(make_pair(cur.first - 1, cur.second));
					}
				}
			}
			else if (u == 6) {
				if (f[cur.first + 1][cur.second] >= 3) {
					if (dis[cur.first + 1][cur.second] > d) {
						dis[cur.first + 1][cur.second] = d;
						q.push(make_pair(cur.first + 1, cur.second));
					}
				}
				else if (f[cur.first + 1][cur.second] == 0) {
					if (dis[cur.first + 1][cur.second] > d + 1) {
						dis[cur.first + 1][cur.second] = d + 1;
						q.push(make_pair(cur.first + 1, cur.second));
					}
				}
			}
			else {
				if (f[cur.first - 1][cur.second] >= 3) {
					if (dis[cur.first - 1][cur.second] > d) {
						q.push(make_pair(cur.first - 1, cur.second));
						dis[cur.first - 1][cur.second] = d;
					}
				}
				else if (f[cur.first - 1][cur.second] == 0) {
					if (dis[cur.first - 1][cur.second] > d + 1) {
						q.push(make_pair(cur.first - 1, cur.second));
						dis[cur.first - 1][cur.second] = d + 1;
					}
				}
				if (f[cur.first + 1][cur.second] >= 3) {
					if (dis[cur.first + 1][cur.second] > d) {
						q.push(make_pair(cur.first + 1, cur.second));
						dis[cur.first + 1][cur.second] = d;
					}
				}
				else if (f[cur.first + 1][cur.second] == 0) {
					if (dis[cur.first + 1][cur.second] > d + 1) {
						q.push(make_pair(cur.first + 1, cur.second));
						dis[cur.first + 1][cur.second] = d + 1;
					}
				}
				if (f[cur.first][cur.second - 1] >= 3) {
					if (dis[cur.first][cur.second - 1] > d) {
						q.push(make_pair(cur.first, cur.second - 1));
						dis[cur.first][cur.second - 1] = d;
					}
				}
				else if (f[cur.first][cur.second - 1] == 0) {
					if (dis[cur.first][cur.second - 1] > d + 1) {
						q.push(make_pair(cur.first, cur.second - 1));
						dis[cur.first][cur.second - 1] = d + 1;
					}
				}
				if (f[cur.first][cur.second + 1] >= 3) {
					if (dis[cur.first][cur.second + 1] > d) {
						q.push(make_pair(cur.first, cur.second + 1));
						dis[cur.first][cur.second + 1] = d;
					}
				}
				else if (f[cur.first][cur.second + 1] == 0) {
					if (dis[cur.first][cur.second + 1] > d + 1) {
						q.push(make_pair(cur.first, cur.second + 1));
						dis[cur.first][cur.second + 1] = d + 1;
					}
				}
			}
		}
		f[start.first][start.second] = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (e[i][j]) printf("%d\n", (dis[i][j] != INF ? dis[i][j] : -1));
			}
		}
	}
	else {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (e[i][j]) printf("%d\n", -1);
			}
		}
	}
	return 0;
}
