class Solution {
public:
    int countElements(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());

        int count=0,n=nums.size();

        for(int i=0;i<n;i++){

            int idx=upper_bound(nums.begin(),nums.end(),nums[i])-nums.begin();

            if(n-(idx)>=k) count++;
            else break;
        }

        return count;
    }
};