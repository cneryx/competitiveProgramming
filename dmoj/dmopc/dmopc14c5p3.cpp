#include <bits/stdc++.h>
#define min(x, y) (x < y ? x : y);
int grid[1001][1001];
int dp[1001][1001];
int main() {
	int l, d;
	scanf("%d %d", &l, &d);
	memset(grid[0], 0x3f3f3f3f, sizeof(grid[0]));
	memset(dp[0], 0x3f3f3f3f, sizeof(dp[0]));
	for (int i = 1; i <= d; i++) {
		memset(grid[i], 0x3f3f3f3f, sizeof(grid[i]));
		memset(dp[i], 0x3f3f3f3f, sizeof(dp[i]));
		for (int j = 1; j <= l; j++) {
			scanf("%d", &grid[i][j]);
		}
	}
	dp[1][1] = grid[1][1];
	for (int i = 2; i <= l; i++) {
		dp[1][i] = dp[1][i - 1] + grid[1][i];
	}
	for (int i = 2; i <= d; i++) {
		for (int j = 1; j <= l; j++) {
			dp[i][j] = min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
		}
		for (int j = l; j >= 1; j--) {
			dp[i][j] = min(dp[i][j], dp[i][j + 1] + grid[i][j]);
		}
	}
	int x, y;
	scanf("%d %d", &x, &y);
	printf("%d", dp[y+1][x+1]);
	return 0;
}
