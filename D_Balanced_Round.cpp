#include<iostream>
#include<vector>
#include<set>
#include<algorithm>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    int n, k;
    int count=0;
    cin>>n;
    cin>>k;
    vector<int> vec(n);
    for(int &x:vec){
        cin>>x;
    }
    sort(vec.begin(),vec.end());
    int i=1;
    
    int current_streak = 1;
    int max_streak = 1;
    while(i<n){
        if (vec[i] - vec[i - 1] <= k) {
            current_streak++;
        } else {
            current_streak = 1;
        }
        max_streak = max(max_streak, current_streak);
        i++;
    }
    cout<<n-max_streak<<endl;
}

int main(){
    int t;
    cin>>t;
    while (t--){
        sol();
    }    
    return 0;
}