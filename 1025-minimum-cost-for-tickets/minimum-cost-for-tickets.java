class Solution {
    Integer[][] dp;
    int cost(int idx,int[] days,int[] costs,int covered){
        if(idx>=days.length) return 0;

        if(dp[idx][covered]!=null) return dp[idx][covered];

        int day=days[idx];
        int amount=Integer.MAX_VALUE;

       

        if(covered>=day){
            amount=cost(idx+1,days,costs,covered);
            
        }
        else{

            for(int i=0;i<costs.length;i++){
                int toCover=0;
                if(i==1) toCover=6;
                else if(i==2) toCover=29;

                if(day+toCover<400){
                    amount=Math.min(amount,costs[i]+cost(idx+1,days,costs,day+toCover));
                }
            }
        }

        return dp[idx][covered] =amount;

    }
    public int mincostTickets(int[] days, int[] costs) {

        dp=new Integer[days.length+1][400];

        return cost(0,days,costs,0);
        
    }
}