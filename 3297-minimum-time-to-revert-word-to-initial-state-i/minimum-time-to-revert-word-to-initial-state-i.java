class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n=word.length();
        if(k==n) return 1;
        String temp=word;
        int count=0;

        while(true){

            temp=temp.substring(k);
            count++;
            
            if(word.startsWith(temp)) return count;

            if(temp.length()<=k) {
                count++;
                break;
            }
            
            
        }

        return count;
        
    }
}