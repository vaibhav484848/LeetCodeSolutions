class Solution {
public:
    long long perfectPairs(vector<int>& nums) {
        // -3 5 -> 2 -> 8
        // -2 10 -> 8 -> 12

        // -6 10 -> 4 -> 16

        long long sum=0;

        int n=nums.size();

        sort(nums.begin(),nums.end());

        for(int i=1;i<n;i++){
            int ele=nums[i];
            
            // positive
            auto low=lower_bound(nums.begin(),nums.begin()+i,(ele+1)/2)-nums.begin();

            sum+=1l*(i-low);

            //neg

            if(ele==0) continue;

        //    -12 -10 -8 -7 -5 -4
            int sign=(ele<0)?-1:1;

            int hiEle=-1*(ele+1)/2;
            int lowerhiEle=-2*sign*ele;
            
            
            
            auto hi=upper_bound(nums.begin(),nums.begin()+i,-1*(ele+1)/2)-nums.begin();
            auto lowerhi=lower_bound(nums.begin(),nums.begin()+i,-2*sign*ele)-nums.begin();

            
            long long totNeg=1l*(hi-lowerhi);

            sum+=1l*(totNeg);

            



        }

        return sum;
    }
};