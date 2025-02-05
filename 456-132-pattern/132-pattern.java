class Solution {
    public boolean find132pattern(int[] nums) {

        int n=nums.length;

        

        int[] pge=new int[n];

        int[] min=new int[n];
        min[0]=Integer.MAX_VALUE;
        
        for(int i=1;i<n;i++){
            min[i]=Math.min(min[i-1],nums[i-1]);
           
        }

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            int ele=nums[i];
            while(st.size()>0 && nums[st.peek()]<=ele){
                st.pop();
            }
            if(st.size()==0) pge[i]=Integer.MIN_VALUE;
            else pge[i]=st.peek();

            st.push(i);
        }


        // System.out.println(Arrays.toString(pge));

        for(int i=2;i<n;i++){
            if(pge[i]!=Integer.MIN_VALUE && min[pge[i]] <nums[i]) {
                System.out.println(i);
                return true;
            }
        }

        return false;


        
    }
}