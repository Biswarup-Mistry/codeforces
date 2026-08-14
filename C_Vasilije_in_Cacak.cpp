#include<iostream>
#include<vector>
#include<set>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    long long n,k,x;
    cin>>n>>k>>x;
    long long max_sum=(k*(2*n-k+1)/2);
    long long min_sum=(k*(k+1)/2);
    if((max_sum>=x) && (x>=min_sum)){
        cout<<"YES"<<endl;
    }
    else{
        cout<<"NO"<<endl;
    }
}

int main(){
    int t;
    cin>>t;
    while (t--){
        sol();
    }    
    return 0;
}