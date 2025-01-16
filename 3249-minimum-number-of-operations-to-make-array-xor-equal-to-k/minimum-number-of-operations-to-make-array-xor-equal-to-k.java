class Solution {
    public int minOperations(int[] nums, int k) {

        int xor=0;

        for(int i=0;i<nums.length;i++){
            xor^=nums[i]; 
        }
    
        int count=0;

        for(int i=0;i<32;i++){
            if(((xor & (1<<i))!=0 &&   (k & (1<<i))!=0) || ( ((xor & (1<<i))==0 &&   (k & (1<<i))==0)) ){
                continue;
            }
            
            else{
                count++;
            }
        }

        return count;
        
    }
}