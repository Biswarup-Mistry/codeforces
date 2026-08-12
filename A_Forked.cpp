#include<iostream>
#include<vector>
#include<set>
using namespace std;

int main(){
    int t;
    cin>>t;
    int dx[4]={1, -1, 1, -1}, dy[4]={1,1,-1,-1};
    while(t--){
    long long a,b;
    long long k_x,k_y;
    long long q_x,q_y;
        cin>>a>>b;
        cin>>k_x>>k_y;
        cin>>q_x>>q_y;
        set<pair<int, int>> k_h, q_h;
        for(int i=0;i<4;i++){
            k_h.insert({k_x+dx[i]*a,k_y+dy[i]*b});
            k_h.insert({k_x+dx[i]*b,k_y+dy[i]*a});
            
            q_h.insert({q_x+dx[i]*a,q_y+dy[i]*b});
            q_h.insert({q_x+dx[i]*b,q_y+dy[i]*a});
        }
        int ans=0;
        for(auto position:k_h)
            if(q_h.find(position)!=q_h.end())
                ans++;
        cout<<ans<<endl;
        
    }
    return 0;
}