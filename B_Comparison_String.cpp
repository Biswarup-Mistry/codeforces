#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
#include<set>
using namespace std;

void sol(){
    //cout<<"Hellow World !\n";
    int n;
    cin>>n;
    vector<char> str(n);
    vector<int> vec(n+1);
    for(char &x:str){
        cin>>x;
    }
    /*int i=0;
    int count=0;
    vec[i]=0;
    while(i<n){
        if(str[i]=='<'){
            count++;
            vec[i+1]=count;
        }
        else{
            count--;vec[i+1]=count;
        }
        i++;
    }
    sort(vec.begin(), vec.end());
    if(vec[0]<0){
        cout<<(vec[0]*(-1))+1<<endl;
    }
    else{cout<<vec[n]+1<<endl;}*/
    int max_streak=1;
    int current=1;int i=1;
    while(i<n){
        if(str[i]==str[i-1]){current++;}
        else{current=1;}
        max_streak=max(max_streak,current);
        i++;
    }
    cout<<max_streak+1<<endl;
}

int main(){
    int t;
    cin>>t;
    while (t--){
        sol();
    }    
    return 0;
}