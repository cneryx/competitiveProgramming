#include <bits/stdc++.h>
double x;
double pow(int y) {
	double ans = x;
	for (int i = 1; i < y; i++) {
		ans = pow(x, ans);
	}
	return ans;
}
int main() {
	int q;
	scanf("%d", &q);
	for (int i = 0; i < q; i++) {
		int y, z;
		x = 5.5;
		scanf("%d %d", &y, &z);
		double l = 1.0;
		double u = 10.0;
		while (true) {
			double ans = pow(y);
			if (u - l  <= 0.00001) break;
			if (ans - z > 0) {
				u = x;
				x = (l + x) / 2.0;
			}
			else if (ans - (z/1.0) < 0) {
				l = x;
				x = (u + x) / 2.0;
			}
		}
		printf("%f\n", x);
	}
	return 0;
}
