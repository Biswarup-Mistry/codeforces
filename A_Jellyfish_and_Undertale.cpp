#include<iostream>
#include<vector>
#include<set>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    long long a,b,n;
    cin>>a>>b>>n;
    vector<long long> vec(n);
    for(long long &x:vec){
        cin>>x;
    }
    long long c=1;
    long long ans=b-1;
    // if(c!=1){
    //     ans=b-1;
    //     c=1;
    // }   
    for(int i=n-1;i>=0;i--){
        c=min(c+vec[i],a);
        ans=ans+c-1;
        c=1;
    }
    cout<<ans+1<<endl;


}

int main(){
    int t;
    cin>>t;
    while (t--){
        sol();
    }    
    return 0;
}