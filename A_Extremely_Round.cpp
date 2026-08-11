#include<iostream>
#include<vector>
using namespace std;

int main(){
    int t;
    cin>>t;
    while (t--)
    {
        long long ans=0;
        int n;
        cin >> n;
        while(n>9){
            n/=10;
            ans+=9;
        }
        cout<<ans+n<<endl;
    }
    
}