#include <bits/stdc++.h>

int main() {
	int n, q, a, b, t;
	int sum[500001];
	scanf("%d %d", &n, &q);
	sum[0] = 0;
	for (int i = 1; i <= n; i++) {
		scanf("%d", &sum[i]);
		sum[i] += sum[i - 1];
		
	}
	t = sum[n];
	for (int i = 0; i < q; i++) {
		scanf("%d %d", &a, &b);
		printf("%d\n", t-(sum[b] - sum[a-1]));
	}
	return 0;
}
