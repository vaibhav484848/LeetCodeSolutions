class Solution {
public:
    int minimumLevels(vector<int>& possible) {
        int n=possible.size();
        vector<int> prefix(n,0);


        prefix[0]=possible[0]*2-1;
       
        for(int i=1;i<n;i++){
            int ele=possible[i];
            
            prefix[i]=prefix[i-1]+1;
            if(ele==0) prefix[i]-=2;
            
        }
        int total=prefix[n-1];
        

        for(int i=0;i<n-1;i++){
            int bob=total-prefix[i];

            if(prefix[i]>bob) return i+1;
        }
        return -1;
        
    }
};