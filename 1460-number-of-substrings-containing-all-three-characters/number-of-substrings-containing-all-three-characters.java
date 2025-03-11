class Solution {
    int ans(String s,int k){
        int n=s.length();

        HashMap<Character,Integer> map=new HashMap<>();

        int l=0,r=0;
        int count=0;

        while(r<n){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.size()>k){
                char chL=s.charAt(l);
                if(map.get(chL)==1) map.remove(chL);
                else map.put(chL,map.get(chL)-1);
                l++;
            }
            count+=(r-l+1);
            r++;
        }

        return count;
    }
    public int numberOfSubstrings(String s) {
        return ans(s,3)-ans(s,2);
    }
}