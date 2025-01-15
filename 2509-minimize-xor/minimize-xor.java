class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBits2=Integer.bitCount(num2);

        int result=0;

        for(int i=31;i>=0 && setBits2>0;i--){
            if((num1 & (1<<i))>0){
                result|=(num1 & (1<<i));
                setBits2--;
            }
        }
        for(int i=0;i<32 && setBits2>0;i++){
            if((num1 & (1<<i))==0){
                result|= (1<<i);
                setBits2--;
            }
        }

        return result;
    }
}