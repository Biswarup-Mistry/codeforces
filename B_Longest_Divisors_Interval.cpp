#include<iostream>
#include<vector>
#include<set>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    long long n;
    cin>>n;
    long long count=1;
    while(n%count==0){count++;}
    cout<<count-1<<endl;
}

int main(){
    int t;
    cin>>t;
    while (t--){
        sol();
    }    
    return 0;
}