class Solution {
public:
    long long maximumScore(vector<int>& nums, string s) {
        priority_queue<int>pq;

        int n=nums.size();
        long long sum=0;

        for(int i=0;i<n;i++){
            if(s[i]=='0'){

                pq.push(nums[i]);
            } 
            else{
                if(pq.size()==0){
                    sum+=nums[i];
                }
                else{
                    int ele=pq.top();
                    if(ele>nums[i]){
                        sum+=ele;
                        pq.pop();
                        pq.push(nums[i]);
                    }
                    else{
                        sum+=nums[i];
                    }
                }
            }
        }

        return sum;
    }
};