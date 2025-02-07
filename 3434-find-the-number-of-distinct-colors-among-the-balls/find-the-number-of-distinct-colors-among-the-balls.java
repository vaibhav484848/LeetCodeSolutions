class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        
        HashMap<Integer,Integer> map = new HashMap<>();

        int n=queries.length;

        // int[] arr=new int[limit+1];
        HashMap<Integer,Integer> arr=new HashMap<>();
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            int a=queries[i][0];
            int b=queries[i][1];

            
                if(!arr.containsKey(a)) {
                    // arr[a]=b;
                    arr.put(a,b);
                    map.put(b,map.getOrDefault(b,0)+1);
                }
                else{
                    int prevColor=arr.get(a);
                    // arr[a]=b;
                    arr.put(a,b);
                    if(map.get(prevColor)==1) map.remove(prevColor);
                    else map.put(prevColor,map.get(prevColor)-1);

                    map.put(b,map.getOrDefault(b,0)+1);
                    
                }
                
                ans[i]=map.size();
            
        }

        return ans;
        
    }
}