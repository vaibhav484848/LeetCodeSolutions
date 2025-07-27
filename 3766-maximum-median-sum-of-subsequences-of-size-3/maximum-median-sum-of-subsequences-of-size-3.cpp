class Solution {
public:
    long long maximumMedianSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());

        int n=nums.size();

        int times=n/3;

        long long sum=0;
        int j=n-1;
        while(times--){
            sum+=(nums[j-1]);
            j-=2;
        }
        return sum;

    }
};