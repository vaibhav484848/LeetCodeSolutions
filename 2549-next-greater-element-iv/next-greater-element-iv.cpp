class Solution {
public:
    vector<int> secondGreaterElement(vector<int>& nums) {
        int n=nums.size();

        vector<int>ans(n,-1);

        stack<int>st;
        
        priority_queue<int>pq;

        for(int i=0;i<n;i++){
            while(pq.size()>0 && nums[pq.top()]<nums[i]){
                ans[pq.top()]=nums[i];
                pq.pop();
            }
            while(st.size()>0 && nums[st.top()]<nums[i]){
                pq.push(st.top());
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
};