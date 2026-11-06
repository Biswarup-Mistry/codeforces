#include<iostream>
#include<vector>
#include<set>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    int n;
    cin>>n;
    vector<long long> a(n);
    for(long long &x:a){
        cin>>x;
    }
    int count=0;
    for(int i=n-2;i>=0;i--){
        while(a[i]>=a[i+1] && a[i]>0){
            a[i]=a[i]/2;
            count++;
        }
        if (a[i] >= a[i + 1]) {
            cout << -1 << "\n";
            return;
        }
    }
    cout<<count<<endl;

}

int main(){
    int t;
    cin>>t;
    while (t--){
        sol();
    }    
    return 0;
}