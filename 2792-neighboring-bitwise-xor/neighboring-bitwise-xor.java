class Solution {
    public boolean doesValidArrayExist(int[] derived) {

        int n=derived.length;


        int prevEle=0;
        int prevXor=derived[0];

        for(int i=1;i<n;i++){
            if(prevXor==1){
                if(prevEle==0){
                    prevEle=1;
                }
                else{
                    prevEle=0;
                }

            }
            prevXor=derived[i];
            
        }

        if(prevEle==0){
            if(derived[n-1]==0) return true;
            return false;
        }
        else{
            if(derived[n-1]==1) return true;
            return false;
        }

        
    }
}