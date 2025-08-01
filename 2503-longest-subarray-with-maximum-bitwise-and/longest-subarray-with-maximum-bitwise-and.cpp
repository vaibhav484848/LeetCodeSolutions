class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        // int maxCount=0;
        int n=nums.size();
        int count=0;
        
        int maxE=*max_element(nums.begin(),nums.end());
        int maxCount=1;

        for(int i=0;i<n;i++){
            if(nums[i]==maxE ){
                count++;
                maxCount=max(maxCount,count);
            }
            else count=0;
        }

        return maxCount;
    }
};