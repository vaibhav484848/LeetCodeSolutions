class Solution {
    public int minOperations(int[] nums, int k) {

        int[] bitArray= new int[32];

        for(int i=0;i<nums.length;i++){

            int ele=nums[i];

            for(int ii=0;ii<32;ii++){

                bitArray[ii]+=((ele & (1<<ii))!=0?1:0);

            }
        }
    
        int count=0;

        for(int i=0;i<32;i++){
            if((k & (1<<i))!=0){
                if(bitArray[i]%2==0){
                    count++;
                }

            }
            else{
                if(bitArray[i]%2!=0) count++;
            }
        }

        return count;
        
    }
}