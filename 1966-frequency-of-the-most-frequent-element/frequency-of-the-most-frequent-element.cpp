class Solution {
public:
    // 1 2 3 4 5 6 7 8

    //3 6 9

    
    int maxFrequency(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());

        long long i=0,j=0,prev=0,ans=0,sum=0;
        int n=nums.size();

        while(j<n){
            int diff=nums[j]-prev;
            prev=nums[j];
            sum+=(j-i)*diff;

            while(sum>k){
                sum-=(nums[j]-nums[i]);
                i++;
            }
            ans=max(ans,j-i+1);
            j++;
        }

        
        return ans;
    }
};