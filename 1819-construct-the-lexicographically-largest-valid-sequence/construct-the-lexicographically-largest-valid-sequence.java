class Solution {

    int count;
    int[] fans;
    boolean flag;

    boolean helper(int n,boolean[] visited,int idx,int[]ans){
        if(idx==count ) {
            
            return true;
        }
        if(ans[idx]!=0) {
            
            return helper(n,visited,idx+1,ans);
        }
        
        
        for(int i=n;i>=1;i--)
        {

             

            if(visited[i]) continue;
            if(i==1){
                ans[idx]=1;
                visited[i]=true;
                if(helper(n,visited,idx+1,ans)) return true;
                ans[idx]=0;
                visited[i]=false;
               
            }
            else{
                if(idx+i>=ans.length)return false;
                if((ans[idx+i]!=0)) continue;
                ans[idx]=i;
                
                ans[idx+i]=i;
                visited[i]=true;
                if(helper(n,visited,idx+1,ans)) return true;
                ans[idx]=0;
                ans[idx+i]=0;
                visited[i]=false;

               
            }
            
            

        }
        return false;

    }
    public int[] constructDistancedSequence(int n) {

        boolean[] visited=new boolean[n+1];

        
        count=2*n-1;

        int[] ans=new int[count];

        helper(n,visited,0,ans);

        return ans;
        
    }
}