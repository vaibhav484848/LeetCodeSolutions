class Solution {
public:
    int minDeletionSize(vector<string>& strs) {

        

        int count=0;

        int n=strs[0].size();

        vector<string>v(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<strs.size();j++){
                
                if(i<strs[j].size()){
                    if(v[i]!=""){
                        if(v[i][v[i].size()-1]>strs[j][i]){
                            count++;
                            break;
                        }
                    }
                    v[i]+=strs[j][i];
                    
                }
                
            }
        }

        return count;
    }
};