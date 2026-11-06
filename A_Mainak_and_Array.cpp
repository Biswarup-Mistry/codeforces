#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void sol() {
    int n;
    cin >> n;
    vector<long long> a(n);
    
    for (long long &x : a) {
        cin >> x;
    }
    
    if (n == 1) {
        cout << 0 << "\n";
        return;
    }

    // Base difference
    long long max_diff = a[n - 1] - a[0];

    // Try making every element the first element
    for (int i = 0; i < n; i++) {
        max_diff = max(max_diff, a[n - 1] - a[i]);
    }

    // Try making every element the last element
    for (int i = 0; i < n; i++) {
        max_diff = max(max_diff, a[i] - a[0]);
    }

    // Check adjacent differences for full cyclic shifts
    for (int i = 0; i < n; i++) {
        max_diff = max(max_diff, a[i] - a[(i + 1) % n]);
    }

    cout << max_diff << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t--) {
        sol();
    }    
    return 0;
}