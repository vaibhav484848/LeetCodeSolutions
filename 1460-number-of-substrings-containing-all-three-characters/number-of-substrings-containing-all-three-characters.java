class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int l=0,r=0;

        int countSub=0;
        Map<Character,Integer> map=new HashMap<>();

        while(r<n){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.containsKey('a') && map.containsKey('b') && map.containsKey('c')){
                countSub+=(n-r);
                char chL=s.charAt(l);
                if(map.get(chL)==1) map.remove(chL);
                else map.put(chL,map.get(chL)-1);
                l++;
            }
            r++;
        }

        return countSub;
    }
}