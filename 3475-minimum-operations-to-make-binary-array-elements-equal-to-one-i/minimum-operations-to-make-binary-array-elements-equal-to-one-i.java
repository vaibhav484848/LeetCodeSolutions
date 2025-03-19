class Solution {
    public int minOperations(int[] nums) {
        int l=0,r=0,n=nums.length;
        int count=0;

        while(r<n){
            if(nums[r]==1){
                r++;
            }
            else{
                if(r+2<n){
                    for(int i=0;i<3;i++){
                        nums[r]=1-nums[r];
                        r++;
                    }
                    r-=2;
                    count++;
                }
                else
                break;
                
            }
        }
        // System.out.println(Arrays.toString(nums));
        for(int i=0;i<n;i++) if(nums[i]==0) return -1;
        return count;
    }
}