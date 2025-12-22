class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        

        int count=0;

        int n=strs.size();

        vector<string>v(n);

        for(int i=0;i<strs[0].size();i++){
            bool flag=false;

            for(int j=1;j<n;j++){
                if(v[j-1]+strs[j-1][i]>v[j]+strs[j][i]){
                    flag=true;
                    count++;
                    break;
                }
                
                
            }
            if(!flag){
                for(int k=0;k<n;k++){
                    v[k]+=strs[k][i];
                }
            }
        }

        return count;
        
    }
};