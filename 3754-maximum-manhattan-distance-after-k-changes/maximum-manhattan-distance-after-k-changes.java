class Solution {
    
    public int maxDistance(String s, int k) {

        int n=s.length();

        int nC=0;
        int sC=0;
        int eC=0;
        int wC=0;

        int maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='N') nC++;
            else if(ch=='S') sC++;
            else if(ch=='E') eC++;
            else  wC++;

            int diffUp=Math.abs(nC-sC);
            int diffSide=Math.abs(eC-wC);

            int total=diffUp+diffSide;
            
            int minUp=Math.min(nC,sC);
                       
            int minSide=Math.min(eC,wC);  

             int rem=k;
    
            if(minUp>=rem){
                total+=(2*rem);
                rem=0;
               
            }
            else{
                rem-=minUp;
                total+=(2*minUp);
            }
    
            if(minSide>=rem){
                total+=(2*rem);
                rem=0;
                
            }
            else{
                rem-=minSide;
                total+=(2*minSide);
            }

            maxi=Math.max(maxi,total);
            
            
        }

        

        return maxi;

        

       
        
    }
}