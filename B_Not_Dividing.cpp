#include <iostream>
#include <vector>
using namespace std;

void sol() {
    int n;
    cin >> n;
    vector<long long> a(n);
    
    for (long long &x : a) {
        cin >> x;
    }
    
    // 1. Convert all 1s to 2s (since 1 divides everything)
    for (int i = 0; i < n; i++) {
        if (a[i] == 1) {
            a[i] = 2;
        }
    }
    
    // 2. Simple linear pass: if a[i+1] is divisible by a[i], just bump a[i+1] up by 1
    for (int i = 0; i < n - 1; i++) {
        if (a[i+1] % a[i] == 0) {
            a[i+1]++;
        }
    }
    
    // Fast output
    for (int i = 0; i < n; i++) {
        cout << a[i] << (i == n - 1 ? "" : " ");
    }
    cout << "\n";
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