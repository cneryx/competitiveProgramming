#include <bits/stdc++.h>
int lights[30] = { 0 };
bool num[513] = { false };
int main() {
	int l, r, count = 0;
	scanf("%d\n%d", &r, &l);
	for (int i = 0; i < r; i++) {
		for (int j = 0, d; j < l; j++) {
			scanf("%d", &d);
			d <<= l-j-1;
			lights[i] |= d;
		}
	}
	for (int i = 0, n; i < r; i++) {
		n = lights[i];
		for (int j = i + 1; j < r; j++) {
			n ^= lights[j];
		}
		if (!num[n]) {
			num[n] = true;
			count++;
		}
	}
	printf("%d", count);
	return 0;
}
