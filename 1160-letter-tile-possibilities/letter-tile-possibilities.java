class Solution {
    HashSet<String> set;
    void subseq(String s,String str){
        if(s.length()==0) {
            set.add(str);
            return;
        }
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            subseq(s.substring(0,i)+s.substring(i+1),str);
            subseq(s.substring(0,i)+s.substring(i+1),str+ch);
        }
        
    }
    public int numTilePossibilities(String tiles) {

        set=new HashSet<>();
        subseq(tiles,"");
        // System.out.println(set);
        return set.size()-1;
    }
}