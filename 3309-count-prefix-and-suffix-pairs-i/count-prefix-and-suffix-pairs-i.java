class Solution {
    int[] kmp(String s){
        int n=s.length();
        int [] lcs=new int[n];

        for(int i=1;i<n;i++){
            int prevIdx=lcs[i-1];
            
            while(prevIdx>0 && s.charAt(i)!=s.charAt(prevIdx)){
                prevIdx=lcs[prevIdx-1];
            }
            lcs[i]=prevIdx+(s.charAt(i)==s.charAt(prevIdx)?1:0);
        }

        return lcs;
    }
    public int countPrefixSuffixPairs(String[] words) {

        int n=words.length;

        int count=0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int s1L=words[i].length();
                int s2L=words[j].length() ;

                if(s1L<=s2L){
                    int[] kmpJ=kmp(words[i]+"#"+words[j]);
                    if(kmpJ[2*s1L]==s1L && kmpJ[kmpJ.length-1]==s1L){
                        count++;
                    }

                }

                
            }
        }

        return count;


        
    }
}