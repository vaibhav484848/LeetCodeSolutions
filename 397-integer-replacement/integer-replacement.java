class Solution {
    // Long[] dp;
    HashMap<Long,Integer> map;

    int ans(long n){
        if(n==1 ) return 0;
        

        int pick1=Integer.MAX_VALUE;

        if(map.containsKey(n)) return map.get(n);

        if(n%2==0){

            pick1=1+ans(n/2);
        }
        else{
            pick1=1+ans(n-1);
            pick1=Math.min(pick1,1+ans(n+1));
        }

        map.put(n,pick1);

        return pick1;
    }
    public int integerReplacement(int n) {

        int count=0;
        map=new HashMap<>();
        return ans(n);

        


        
    }
}