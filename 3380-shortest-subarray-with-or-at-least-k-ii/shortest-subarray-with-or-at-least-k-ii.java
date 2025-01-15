class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        
        int[] bitArray=new int[32];

        int n=nums.length;

        int l=0,r=0;
        int len=Integer.MAX_VALUE;

        while(r<n){

            adjustBits(bitArray,nums[r],1);

            while(l<=r && bitNum(bitArray,nums[r])>=k){
                len=Math.min(len,r-l+1);
                adjustBits(bitArray,nums[l++],-1);

            }

            r++;

        }

        return len==Integer.MAX_VALUE?-1:len;

        
    }
    int bitNum(int[] bitArray,int num){


       

        int pro=1;
        int sum=0;

        for(int i=0;i<bitArray.length;i++){
            sum+=((bitArray[i]>0?1:0)*pro);
            pro*=2;
        }

        // System.out.println(Arrays.toString(bitArray)+" "+sum);
        return sum;
        
    }

    void adjustBits(int[] bitArray,int num,int val){
        int i=0;

         while(num>0){
            bitArray[i++]+= val*(num%2);
            num/=2;
        }

        return;
        
    }
}