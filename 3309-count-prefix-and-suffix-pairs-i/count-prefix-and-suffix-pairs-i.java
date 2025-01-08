class Solution {
    boolean check(String s1,String s2){
        
        String s21=s2.substring(0,s1.length());
        String s22=s2.substring(s2.length()-s1.length());
        

        if(s22.contains(s1) && s21.contains(s1)) return true;
        return false;
    }
    public int countPrefixSuffixPairs(String[] words) {

        int n=words.length;

        int count=0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                String s1=words[i];
                String s2=words[j];

                if(s1.length()<=s2.length()){
                    if(check(s1,s2)){
                         count++;
                         
                    }    
                }
            }
        }

        return count;
        
    }
}