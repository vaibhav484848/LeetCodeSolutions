class Solution {
public:
    // bool valid(vector<int> flag,vector<vector<int>>& s,int mask){
        
    //     int n=s.size();

    //     // cout<<"mask: "<<mask<<'\n';
    //     // for(int i=0;i<n;i++) cout<<flag[i]<<" ";
    //     // cout<<'\n';

    //     for(int i=0;i<n;i++){
    //         if(flag[i]==1){
    //             // cout<<"flagI: "<<i<<'\n';
    //             for(int k=0;k<n;k++){
    //                 if(s[i][k]!=2){
    //                     if(flag[k]==2){
    //                         flag[k]=s[i][k];
    //                     }
                        
    //                     // else 
    //                     else if(flag[k]!=2 && s[i][k]!=flag[k]) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }
    bool valid(vector<vector<int>>& s,int mask){

        int n=s.size();


       for(int i=0;i<(n);i++){
        if(mask&(1<<i)){

            for(int j=0;j<n;j++){
                if(s[i][j]==2) continue;

                else{
                    int assStatus=((mask&(1<<j))?1:0);

                    if(s[i][j]!=assStatus) return false;
                }
            }
        }
       }
       return true;

    }
    int maximumGood(vector<vector<int>>& statements) {
        int n=statements.size();
        int ans=0;

        for(int mask=1;mask<(1<<n);mask++){
            
            
            if(valid(statements,mask)){
                int count=__builtin_popcount(mask);
                ans=max(ans,count);
            } 
        }

        return ans;

    }
};