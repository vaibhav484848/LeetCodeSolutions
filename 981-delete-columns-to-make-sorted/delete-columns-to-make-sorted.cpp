class Solution {
public:
    int minDeletionSize(vector<string>& strs) {

        vector<string>v(1000);

        int count=0;

        for(int i=0;i<1000;i++){
            bool flag=false;
            for(int j=0;j<strs.size();j++){
                
                if(i<strs[j].size()){
                    if(v[i]!=""){
                        if(v[i][v[i].size()-1]>strs[j][i]){
                            count++;
                            break;
                        }
                    }
                    v[i]+=strs[j][i];
                    flag=true;
                }
                
            }
            if(!flag)break;
        }

        return count;
    }
};