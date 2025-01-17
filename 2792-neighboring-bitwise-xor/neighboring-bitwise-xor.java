class Solution {
    public boolean doesValidArrayExist(int[] derived) {

        int n=derived.length;

        int xorValue=0;

        for(int i=0;i<n;i++){
            xorValue^=derived[i];
        }
        return xorValue==0;

        
    }
}