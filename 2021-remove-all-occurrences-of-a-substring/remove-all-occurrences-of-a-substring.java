class Solution {
    public String removeOccurrences(String s, String part) {
        
        int idx=s.indexOf(part);

        int pL=part.length();

        if(idx==-1) return s;

        while(idx!=-1){
            s=s.substring(0,idx)+s.substring(idx+pL);
            idx=s.indexOf(part);
        }

        return s;
        

    }
}