class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
       
        int ans=0;
        int prev=-1;
        for(string s:bank){
            int count=0;
            for(char ch:s){
                if(ch=='1') count++;
            }
            if(count==0) continue;
            if(prev!=-1)
            ans+=(prev*count);
            prev=count;
        }
        return ans;
        
    }
};