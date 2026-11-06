#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

void sol() {
    int n;
    cin >> n;
    vector<long long> a(n);
    
    for (long long &x : a) {
        cin >> x;
    }
    
    int seg = 0;
    int k = 0;
    
    while (k < n) {
        // 1. Skip all zeros to find the start of a non-zero segment
        while (k < n && a[k] == 0) {
            k++;
        }
        
        // If we reached the end of the array, stop
        if (k >= n) break;
        
        // We found a new non-zero segment!
        seg++;
        
        // 2. Skip through the entire non-zero segment
        while (k < n && a[k] != 0) {
            k++;
        }
    }
    
    // The answer is capped at 2
    if (seg > 2) {
        seg = 2;
    }
    
    // Use \n instead of endl for Codeforces performance
    cout << seg << "\n";
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