class Solution {
public:
    vector<int> secondGreaterElement(vector<int>& nums) {
        int n=nums.size();

        vector<int>ans(n,-1);

        stack<int>st,st2,temp;
        
        // priority_queue<int>pq;

        for(int i=0;i<n;i++){
            while(st2.size()>0 && nums[st2.top()]<nums[i]){
                ans[st2.top()]=nums[i];
                st2.pop();
            }
            while(st.size()>0 && nums[st.top()]<nums[i]){
                temp.push(st.top());
                // st2.push(st.top());
                st.pop();
            }
            while(temp.size()>0){
                st2.push(temp.top());
                temp.pop();
            }
            st.push(i);
        }
        return ans;
    }
};