class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n=nums.size();
        int maxCount=0;

        int count0=0;
        int count1=0;

        map<int,int> mp;

        for(int i=0;i<n;i++){
            if(nums[i]==0) count0++;
            else count1++;

            int diff=count1-count0;
            // cout<<diff<<endl;
            if(diff==0){
                maxCount=i+1;
            }

            if(mp.find(diff)!=mp.end()){
                maxCount=max(maxCount,i-mp[diff]);
            }
            else
            mp[diff]=i;
        }
        


        return maxCount;
    }
};