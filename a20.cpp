#include <iostream>
#include <vector>

using namespace std;

void sol() {
    int n, q;
    cin >> n >> q;

    // Use 1-based indexing for convenience (pref[0] = 0)
    vector<long long> pref(n + 1, 0);

    for (int i = 1; i <= n; i++) {
        long long val;
        cin >> val;
        pref[i] = pref[i - 1] + val;
    }

    long long total_sum = pref[n];

    for (int i = 0; i < q; i++) {
        long long l, r, k;
        cin >> l >> r >> k;

        // O(1) sum extraction for the replaced range
        long long old_range_sum = pref[r] - pref[l - 1];
        long long new_range_sum = (r - l + 1) * k;
        long long new_total = total_sum - old_range_sum + new_range_sum;

        if (new_total % 2 != 0) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
}

int main() {
    // Fast I/O is mandatory to read ~400,000 integers quickly
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        sol();
    }
    return 0;
}