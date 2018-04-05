#include <bits/stdc++.h>
int n, m, p[100001];

int find(int u) {
	if (p[u] == u) return u;
	return p[u] = find(p[u]);
}
void merge(int x, int y) {
	x = find(x);
	y = find(y);
	p[x] = y;
	return;
}

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		p[i] = i;
	}
	for (int i = 0, k; i < m; i++) {
		scanf("%d ", &k);
		int c[100001];
		for (int j = 0; j < k; j++) {
			scanf("%d", &c[j]);
			if (j != 0) merge(c[j], c[j - 1]);
		}
	}
	bool inf[100001] = { false };
	int count = 0;
	for (int i = 1; i <= n; i++) {
		if (find(i) == find(1)) {
			count++;
			inf[i] = true;
		}
	}
	printf("%d\n", count);
	for (int i = 1; i <= n; i++) {
		if (inf[i]) printf("%d ", i);
	}
	return 0;
}
