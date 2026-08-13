#include<iostream>
#include<vector>
using namespace std;
 
int main(){
    int t;
    cin>>t;
    while (t--){
        vector<int> vec(3);
        for(int &x:vec){
            cin>>x;
        }
        int n=vec[0];
        int a=vec[1];
        int b=vec[2];
        if((n-(a+b)>=2) || (n==b && n==a)){
            cout<<"Yes"<<endl;
        }
        else{cout<<"No"<<endl;}
    }    
}