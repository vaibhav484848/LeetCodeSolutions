class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n=asteroids.length;

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            int ele=asteroids[i];

            boolean flag=false;
            if(st.size()==0 || ele>0) st.push(ele);

            else if(st.size()>0 && st.peek()<0) st.push(ele);

            else{
               

                while(st.size()>0 && st.peek()>0 && st.peek()<Math.abs(ele) ){
                    st.pop();
                }

                if(st.size()>0 && st.peek()==Math.abs(ele)){
                    st.pop();
                    continue;
                }
                if(st.size()>0 && st.peek()>Math.abs(ele)){
                    continue;
                }

                st.push(ele);


            }
            
            
        }
        

        int sL=st.size();

        int[] ans=new int[sL];

        for(int i=sL-1;i>=0;i--){
            ans[i]=st.pop();
        }

        

        

        return ans;
        
    }
}