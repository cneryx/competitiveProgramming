#include <bits/stdc++.h>
typedef long long ll;
using namespace std;
ll gcd(ll x, ll y) {
	if (x == 0) return y;
	return gcd(y % x, x);
}
int main() {
	ll n, ans, f = -1;
	ll arr[100000];
	scanf("%lld", &n);
	for (int i = 0; i < n; i++) {
		scanf("%lld", &arr[i]);
	}
	ans = arr[0];
	for (int i = 1; i < n; i++) {
		ans = gcd(arr[i], ans);
	}
	while (ans % 2 == 0) { 
		f = 2;
		ans /= 2; 
	}
	for (int i = 3; i <= sqrt(ans); i+=2) {
		while (ans%i == 0) {
			f = i;
			ans /= i;
		}
	}
	if (ans > 2) f = max(f, ans);
	if (f == -1) printf("DNE\n");
	else printf("%lld\n", f);
	return 0;
}
