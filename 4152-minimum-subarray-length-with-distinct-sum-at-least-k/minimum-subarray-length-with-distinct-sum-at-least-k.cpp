class Solution {
public:
    int minLength(vector<int>& nums, int k) {
        int n=nums.size();

        int i=0,j=0,ans=INT_MAX;
        long long sum=0;

        map<int,int>mp;


        while(j<n){
            int ele=nums[j];
            if(mp.find(ele)==mp.end())sum+=ele;
            mp[ele]++;
            

            while(sum>=k){
                ans=min(ans,j-i+1);

                mp[nums[i]]--;

                if(mp[nums[i]]==0){
                    mp.erase(nums[i]);
                    sum-=nums[i];
                }
                i++;

            }
            j++;
        }

        return (ans==INT_MAX)?-1:ans;
    }
};