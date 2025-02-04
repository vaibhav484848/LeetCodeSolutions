class Solution {
    public int maxWidthRamp(int[] nums) {

        int n=nums.length;

        Stack<Integer> st=new Stack<>();

        int ans=0;

        for(int i=0;i<n;i++){
            int ele=nums[i];
            if(st.size()==0) st.push(i);
            else if(st.size()>0 && nums[st.peek()]>ele) st.push(i);
        }
        int j=n-1;
        
        while(j>=0 && st.size()>0){
            while(st.size()>0 && nums[st.peek()]<=nums[j]){
                ans=Math.max(ans,j-st.peek());
                st.pop();
            }
            j--;

        }
        return ans;
        
    }
}