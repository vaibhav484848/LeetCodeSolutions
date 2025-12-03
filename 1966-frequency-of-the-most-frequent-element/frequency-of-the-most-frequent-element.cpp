class Solution {
public:
    // 1 2 3 4 5 6 7 8

    //3 6 9

    bool check(int mid,vector<int>& nums, int k){
        long long medIdx=(mid-1)/2,sum=0;

        int n=nums.size();

        int windowL=mid-1;
        for(int i=0;i<n;i++){
            sum+=abs(nums[windowL]-nums[i]);
            if(i>=mid){
                int diff=nums[i]-nums[i-1];
                sum+=(diff*(mid-1));
                // sum-=(nums[medIdx-1]-nums[i-mid]);
            }
            if(i>=mid-1){
                
                // cout<<mid<<" "<<medIdx<<" "<<sum<<"\n";
                if(sum<=k) return true;
                sum-=(nums[windowL]-nums[i-(mid-1)]);
                windowL++;
            }
        }
        return false;
    }
    int maxFrequency(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());

        int lo=1,hi=nums.size(),ans=0;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            if(check(mid,nums,k)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }

        return ans;
    }
};