class Solution {
    public int minimumLength(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int sum=0;

        for(char ch:map.keySet()){
            int freq=map.get(ch);
            if(freq>2){
                if(freq%2==0){
                    sum+=(freq-2);
                }
                else{
                    sum+=(freq-1);
                }
            }
        }

        return n-sum;
    }
}