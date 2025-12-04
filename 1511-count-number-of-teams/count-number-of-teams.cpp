class Solution {
public:
// 0 1 2 3 4 5 6 7

    int numTeams(vector<int>& rating) {
        int n=rating.size();
        
        vector<int>preL(n),preS(n);

        vector<int>v;
        v.push_back(rating[n-1]);

        for(int i=n-2;i>=0;i--){
            int ele=rating[i];

            int size=v.size();
            preL[i]=size-(upper_bound(v.begin(),v.end(),ele)-v.begin());
            preS[i]=lower_bound(v.begin(),v.end(),ele)-v.begin();
            v.push_back(ele);
            sort(v.begin(),v.end());
        }

       
        int ans=0;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(rating[j]>rating[i]){
                    ans+=preL[j];
                }
                if(rating[i]>rating[j]){
                    ans+=preS[j];
                }
            }
        }

        return ans;
    }
};