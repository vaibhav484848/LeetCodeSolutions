class Solution {
    int Neg=Integer.MIN_VALUE;
    int m;
    int n;

    Integer[][][] dp;
    int amount(int lifeSaver,int i,int j,int[][] coins){
        if(i>=m || j>=n ) return Neg;

        if(i==m-1 && j==n-1){
            if(coins[i][j]<0){
                if(lifeSaver>0) return 0;
                return coins[i][j];
                
            }
            return coins[i][j];
        }
        if(dp[i][j][lifeSaver] !=null) return dp[i][j][lifeSaver];

        int pick1=Neg;

        if( coins[i][j] <0 && lifeSaver>0){
           
                
                pick1= amount(lifeSaver-1,i+1,j,coins);
            
           
                pick1=Math.max(pick1,amount(lifeSaver-1,i,j+1,coins));   
            
           
        }

        
           int a=amount(lifeSaver,i+1,j,coins);
        
            int b=amount(lifeSaver,i,j+1,coins); 

            pick1=Math.max(pick1,coins[i][j]+Math.max(a,b));

        
        

        return dp[i][j][lifeSaver] =pick1;
        
    
        
    }
    public int maximumAmount(int[][] coins) {

         m=coins.length;
         n=coins[0].length;

         dp=new Integer[m+1][n+1][3];
      
        int ans=amount(2,0,0,coins);

        return ans;

        
        
    }
}