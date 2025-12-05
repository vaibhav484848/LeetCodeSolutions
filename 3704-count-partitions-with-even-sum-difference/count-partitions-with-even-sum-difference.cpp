class Solution {
public:
    int countPartitions(vector<int>& nums) {
        int n=nums.size();
        vector<int>pre(n,0);
        pre[0]=nums[0];

        for(int i=1;i<n;i++){
            pre[i]=nums[i]+pre[i-1];
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            int ls=pre[i];
            int rs=pre[n-1]-ls;

            if((ls-rs)%2==0) count++;
        }
        return count;

    }
};