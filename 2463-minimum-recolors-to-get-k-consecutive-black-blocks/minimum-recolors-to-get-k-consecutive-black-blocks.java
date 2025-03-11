class Solution {
    public int minimumRecolors(String blocks, int k) {

        Map<Character,Integer> map=new HashMap<>();

        int l=0,r=0;
        int n=blocks.length();

        int countBlack=0;

        while(r<n)
        {
            char ch=blocks.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(r-l+1==k){
                countBlack=Math.max(countBlack,map.getOrDefault('B',0));
                char chL=blocks.charAt(l);
                if(map.get(chL)==1) map.remove(chL);
                else map.put(chL,map.get(chL)-1);
                l++;
                
            }
            r++;
        }

        return k-countBlack;
        
    }
}