class Solution {
    int bitCounter(int num1){
        int count=0;
        for(int i=0;i<32;i++){
            int bitPosition=i;
            count+=(num1 & 1<<bitPosition)!=0?1:0;
        }
        return count;
    }

    void setBit(int num1,int[] bitArray){

         for(int i=0;i<32;i++){
            int bitPosition=i;
            int bitS=(num1 & 1<<bitPosition)!=0?1:0;
            if(bitS==1){
                bitArray[i]=1;
            }
        }

    }
    public int minimizeXor(int num1, int num2) {

        int setBitsNum2=bitCounter(num2);

        int setBitsNum1=bitCounter(num1);

       

        if(setBitsNum1==setBitsNum2) return num1;

        int[] bitArray=new int[32];

        setBit(num1,bitArray);

        int pro=1;
        int sum=0;


        // System.out.println(setBitsNum1+" "+setBitsNum2);
        int count=setBitsNum2-setBitsNum1;

        // System.out.println(count);

        // System.out.println(Arrays.toString(bitArray));
      

        if(count>0){
            for(int i=0;i<32;i++){
                if(count==0) break;
                if(bitArray[i]==0){
                    bitArray[i]=1;
                    count--;
                }
            }

            
            for(int i=0;i<32;i++){
                sum+=(bitArray[i]>0?1:0)*(pro);
                pro*=2;

            }
            return sum;
            
        }
        else{

            count=setBitsNum1-setBitsNum2;


            for(int i=0;i<32;i++){
                if(count==0) break;


                int ele=(bitArray[i]>0?1:0);

                if(ele!=0){
                    bitArray[i]=0;
                    count--;
                }
                pro*=2;
                
                
            }
            pro=1;
            for(int i=0;i<32;i++){
                sum+=(bitArray[i]*pro);
                pro*=2;
            }

            return sum;

        }

        
        

        


      
        
    }
}