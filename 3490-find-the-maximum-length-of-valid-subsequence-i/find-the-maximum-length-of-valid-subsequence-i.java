class Solution {
    public int maximumLength(int[] nums) {

        int n=nums.length;

        int same=0;
        int diff=1;

        int maxLen=1;
        for(int i=0;i<n;i++) nums[i]%=2;
        // for(int i=0;i<n;i++){
        //     System.out.print(nums[i]+" ");
        // }

        int ovSame=0;

        int ev=0,odd=0;

        for(int i=0;i<n;i++){
            if(nums[i]%2==0) ev++;
            else odd++;
        }
        // System.out.println();
        maxLen=Math.max(ev,odd);
        //  System.out.print(maxLen+" ");

        

        int ovDiff=0;

        boolean flag=(nums[0]%2==0?true:false);
        boolean flag2=!flag;

        for(int i=1;i<n;i++){
            if(flag && nums[i]!=0){
                flag=!flag;
                diff++;
            }
            else if(!flag && nums[i]==0){
                flag=!flag;
                diff++;
            }
        }

        maxLen=Math.max(diff,maxLen);
        // System.out.println();
        // System.out.print(maxLen+" ");


        diff=1;

        // for(int i=1;i<n;i++){
        //     if(flag2 && nums[i]!=0){
        //         flag2=!flag2;
        //         diff++;
        //     }
        //     else if(!flag2 && nums[i]==0){
        //         flag2=!flag2;
        //         diff++;
        //     }
        // }

        // maxLen=Math.max(diff,maxLen);

        // System.out.println();
        // System.out.print(maxLen+" ");
        
        return maxLen;
        
    }
}