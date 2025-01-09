class Solution {
    int[] kmp(String s){
        int n=s.length() ;
        int[] lcs=new int[n];

        for(int i=1;i<n;i++){
            
            int prevIdx=lcs[i-1];

            while(prevIdx>0 && s.charAt(i)!=s.charAt(prevIdx)){
                prevIdx=lcs[prevIdx-1];
            }
            lcs[i]=prevIdx+ (s.charAt(i)==s.charAt(prevIdx)?1:0);
        }

        return lcs;
    }
    public int minimumTimeToInitialState(String word, int k) {
        int n=word.length();
        if(k==n) return 1;
        String temp=word;
        int count=0;

        


        while(true){

            temp=temp.substring(k);
            count++;
            
            // if(word.startsWith(temp)) return count;

            int[] kmp1=kmp(temp+"#"+word.substring(0,temp.length()));
            if(kmp1[kmp1.length-1]==temp.length()) return count;



            if(temp.length()<=k) {
                count++;
                break;
            }
            
            
        }

        return count;
        
    }
}