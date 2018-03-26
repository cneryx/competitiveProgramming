#include <bits/stdc++.h>
using namespace std;
const int maxN = 1000001;
vector<int> adj[maxN];
double dp[maxN] = { 0 };
int main() {
	int n, m, x, y;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		adj[x].push_back(y);
	}
	dp[1] = 1;
	for (int i = 1; i <= n; i++) {
		if (adj[i].empty()) continue;
		double prob = (double)dp[i] / adj[i].size();
		for (int j = 0; j < adj[i].size(); j++) {
			dp[adj[i].at(j)] += prob;
		}
	}
	for (int i = 1; i <= n; i++) {
		if (adj[i].empty()) {
			if (dp[i] != 0) printf("%.9f\n", dp[i]);
			else printf("0\n");
		}
	}
	return 0;
}
