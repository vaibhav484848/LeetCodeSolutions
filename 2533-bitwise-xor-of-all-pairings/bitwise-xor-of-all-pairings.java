class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int result=0;

        
        if(nums2.length%2!=0){
            for(int i=0;i<nums1.length;i++){
                result^=nums1[i];
            }

        }
        
        if(nums1.length%2!=0){
            for(int i=0;i<nums2.length;i++) result^=nums2[i];
        }


        return result;
        
    }
}