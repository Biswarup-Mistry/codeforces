#include<iostream>
#include<vector>
#include<set>
#include <numeric>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    int n;
    cin>>n;
    vector<long long> vec(n);
    for(long long &x:vec){
        cin>>x;
    }
    int k=abs(vec[0]-1);
    for(int i=0;i<n;i++){
        k=gcd(k,abs(vec[i]-(i+1)));
    }
    cout<<k<<endl;
}

int main(){
    int t;
    cin>>t;
    while (t--){
        sol();
    }    
    return 0;
}