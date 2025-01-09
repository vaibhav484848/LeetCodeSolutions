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

        int[] kmp1=kmp(word);

        int lcs=kmp1[n-1];
        if(lcs==0){
            return (n+k-1)/k;
        }
        

        int toRemove=n-lcs;

        if(toRemove%k==0){
            return toRemove/k;
        }
        else{
            int prevIdx=kmp1[n-1];

            while(prevIdx>0 && (n-prevIdx)%k!=0){
                prevIdx=kmp1[prevIdx-1];

            }
            toRemove=n-prevIdx;
            if(toRemove%k==0) return toRemove/k;
            return toRemove/k +1;
                        
            
        }
        
        
    }
}