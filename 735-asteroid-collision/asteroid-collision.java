class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n=asteroids.length;

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            int ele=asteroids[i];

            boolean flag=false;
            while(st.size()>0 && st.peek()>0 && ele*st.peek()<0 ){
                int currAst=Math.abs(ele);
                int prevAst=Math.abs(st.peek());

                if(currAst>prevAst){
                    st.pop();
                    
                }
                
                else if(currAst<prevAst){
                    flag=true;
                    break;
                }
                else {
                    flag=true;
                    st.pop();
                    break;
                }
            }
            if(!flag)
            st.push(ele);
        }
        List<Integer> list=new ArrayList<>();


        while(st.size()>0) list.add(st.pop());

        int lS=list.size();

        int[] ans =new int[lS];
        System.out.println(list);

        for(int i=0;i<lS;i++){
            ans[i]=list.get(lS-i-1);
        }

        return ans;
        
    }
}