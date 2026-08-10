#include<iostream>
#include<vector>
using namespace std;

int main(){
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        int count=0;
        cin>>n;
        vector<int> vec(n);
        int temp;
        for(int &x : vec){
            cin>>x;
        }
        int i=0;
        int j=1;
        while(j<=n-1){
            if(vec[i]%2==vec[j]%2){
                count++;
            }
            i++;
            j++;
        }
        cout<<count<<endl;
    }
}
    
