#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100000;
int p[MAXN];
int find(int u) {
	if (p[u] == u) return u;
	return p[u] = find(p[u]);
}
int main() {
	int n, q;
	scanf("%d %d", &n, &q);
	for (int i = 1; i <= n; i++) {
		p[i] = i;
	}
	for (int i = 0, a, b; i < q; i++) {
		char c;
		scanf("\n%c", &c);
		if (c == 'A') {
			scanf("%d %d", &a, &b);
			a = find(a);
			b = find(b);
			p[a] = b;
		}
		else {
			scanf("%d %d", &a, &b);
			printf("%c\n", (find(a) == find(b) ? 'Y' : 'N'));
		}
	}
	return 0;
}
