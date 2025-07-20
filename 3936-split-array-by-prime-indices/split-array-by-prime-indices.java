class Solution {
    

    public long splitArray(int[] nums) {
        int n=nums.length;
        boolean[] isPrime;
        isPrime=new boolean[n];
        for(int i=0;i<n;i++) isPrime[i]=true;

        if(n>1)isPrime[1]=false;
        isPrime[0]=false;

        for(int i=2;i<n;i++){
            if(isPrime[i]){
                for(int j=2*i;j<n;j+=i){
                    isPrime[j]=false;
                }
            }
        }

        long sum1=0,sum2=0;;

        for(int i=0;i<n;i++){
            if(isPrime[i]){
                sum1+=nums[i];
            }
            else sum2+=nums[i];

        }

        return Math.abs(sum1-sum2);
        
    }
}