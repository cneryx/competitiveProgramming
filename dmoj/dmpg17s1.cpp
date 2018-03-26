#include <bits/stdc++.h>
using namespace std;
int num[1000000] = { 1000000001 };

int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num[i]);
	}
	sort(num, num + n);
	int min = 999999999;
	for (int i = 0; i < n-1; i++) {
		if (num[i + 1] - num[i] < min) min = num[i + 1] - num[i];
	}
	printf("%d\n", min);
	return 0;
}
