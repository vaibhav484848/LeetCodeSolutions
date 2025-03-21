class Solution {
    public char findTheDifference(String s, String t) {
        int fSum=0;
        int sSum=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            fSum+=(int)(ch);
        }
        for(int i=0;i<t.length();i++) {
            char ch=t.charAt(i);
            sSum+=(int)(ch);
        }

        return (char)(sSum-fSum);
    }
}