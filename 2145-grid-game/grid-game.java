class Solution {
    public long gridGame(int[][] grid) {

        int n=grid[0].length;

        long[] prefixSum=new long[n];
        prefixSum[0]=(long)grid[0][0];

        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+(long)grid[0][i];
        }
        
        long totalSum1=prefixSum[n-1];
        long rem=Long.MAX_VALUE;
        

        long totalSum2=0;

        for(int i=0;i<n;i++){
            
            long score2=Math.max(totalSum1-prefixSum[i],totalSum2);
            if(rem>score2){
                rem=score2;
            }
             totalSum2+=(long)grid[1][i];

        }

        return rem;


        
    }
}