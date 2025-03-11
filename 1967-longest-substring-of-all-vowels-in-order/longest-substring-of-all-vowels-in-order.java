class Solution {
    public int longestBeautifulSubstring(String word) {

        Map<Character,Integer> map = new HashMap<>();

        int l=0,r=1,n=word.length();
        int count=0;
        map.put(word.charAt(0),1);

        while(r<n){
            char present=word.charAt(r);
            char previous=word.charAt(r-1);
            if(present<previous){
                l=r;
                map.clear();
                map.put(present,1);
                
            }
            else{
                map.put(present,map.getOrDefault(present,0)+1);
                if(map.size()==5){
                    count=Math.max(r-l+1,count);
                }
            }
            r++;
        }

        return count;
        
    }
}