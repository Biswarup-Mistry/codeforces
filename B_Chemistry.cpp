#include<iostream>
#include<vector>
#include<set>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    long long n,k;
    cin>>n>>k;
    string s;
    cin>>s;
    int odd_count=0;
    vector<int> freq(256, 0);
    for (char c : s) {
        freq[c - 'a']++;
    }
    for(int i=0;i<26;i++){
        if(freq[i]%2!=0){odd_count++;}
    }
    if(odd_count-1<=k){
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