#include<iostream>
#include<vector>
#include<set>
#include<cmath>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    long long n;
    cin>>n;
    long long min=0;long long max=0;
    if(n%2!=0 || n<4){cout<<-1<<endl;}
    else{
        max=(n/4);
        min=((n+5)/6);
        cout<<min<<" "<<max<<endl;
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