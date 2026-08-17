#include<iostream>
#include<vector>
#include<set>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    int n;
    cin>>n;
    vector<int> vec(n);
    for(int &x:vec){cin>>x;}
    if(n%2==0){
        cout<<2<<endl;
        cout<<"1 "<<n<<endl<<"1 "<<n<<endl;
    }
    else{
        cout<<4<<endl<<"1 2"<<endl<<"1 2"<<endl<<"2 "<<n<<endl<<"2 "<<n<<endl;
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