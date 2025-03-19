class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l=0,r=0,n=nums.length;
        int maxLen=1;

        int bitsVal=0;
        while(r<n){
            
                while(((bitsVal & nums[r])!=0)){
                    bitsVal=bitsVal^nums[l++]; 
                }
                bitsVal^=nums[r];
                
            maxLen=Math.max(maxLen,r-l+1);
            r++;

        }

        return maxLen;
    }
}