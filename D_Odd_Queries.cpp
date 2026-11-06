#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    int n;int q;long long l;long long r;long long k;
    cin>>n>>q;
    long long c=0;
    vector<long long> a(n);
    
    // Method A: Range-based reference loop (Cleanest)
    for (long long &x : a) {
        cin >> x;
    }
    for(int i=0;i<n;i++){
        c+=a[i];
    }
    /*cout<<c<<endl;*/
    
    for(int i=0;i<q;i++){
        long long s_1=0;long long p_1=0;
        cin>>l>>r>>k;
        for(int j=l-1;j<r;j++){
            s_1+=a[j];
        }
        p_1=c-s_1;
        if((((r-l+1)*k)+p_1)%2==1){
            cout<<"YES"<<endl;
        }
        else{cout<<"NO"<<endl;}
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