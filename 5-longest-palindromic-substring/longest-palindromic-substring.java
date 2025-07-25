class Solution {
    
    boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        
        int n=s.length();
        int maxLen=Integer.MIN_VALUE;
        String fans="";
        for(int i=0;i<n;i++){
            String ans="";
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                ans+=ch;
                int len=j-i+1;
                if(len<maxLen) continue;
                if(isPalindrome(ans)){
                maxLen=Math.max(maxLen,len);
                fans=ans;
                }
                
            }
        }
        return fans;
        
    }
}