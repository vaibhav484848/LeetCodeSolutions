class Solution {
public:
    int specialArray(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n=nums.size();

        int lo=1;
        int hi=n;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            int lb=(lower_bound(nums.begin(),nums.end(),mid)-nums.begin());
            int left=n-lb;
            if(mid==left){
                return mid;
            }
            else if(mid<left){
                lo=mid+1;
            }
            else hi=mid-1;
        }

        return -1;
    }
};