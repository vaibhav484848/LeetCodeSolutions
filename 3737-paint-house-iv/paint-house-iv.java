class Solution {

    int n;
    Long[][][] dp;
   
    long ans(int idx,int prev1,int prev2,int[][] cost){
        
        if(idx>=n/2) return 0;
        
        long pick=Long.MAX_VALUE;

        if(dp[idx][prev1][prev2]!=null) return dp[idx][prev1][prev2];

        for(int i=0;i<3;i++){
            
            for(int j=0;j<3;j++){
                if(j!=i && j!=prev2 && i!=prev1 ){
                    pick=Math.min(pick,cost[idx][i]+cost[n-idx-1][j]+ ans(idx+1,i,j,cost) );
                    
                }
                
            }
        }

        
        return dp[idx][prev1][prev2]=pick;

        
    }
    public long minCost(int n, int[][] cost) {
        
        this.n=n;
        // System.out.println(n);
        dp=new Long[n+1][4][4];


        // System.out.println(Arrays.toString(color));

        return ans(0,3,3,cost);
        
    }
}