class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        HashMap<Integer,int[]> map=new HashMap<>();

        HashMap<Integer,int[]> map2=new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }

        for(int i=0;i<arr.length;i++){
            int[]rowcol =map.get(arr[i]);
            int row=rowcol[0];
            int col=rowcol[1];

            // System.out.println(row+" "+col);
            if(map2.containsKey(row)){
                map2.get(row)[0]++;
                if(map2.get(row)[0]==n) return i;
            }
            else{
                map2.put(row,new int[2]);
                map2.get(row)[0]++;
                if(map2.get(row)[0]==n) return i;
                
            }

            if(map2.containsKey(col)){
                 map2.get(col)[1]++;
                //  System.out.println("0col "+map2.get(col)[1]);
                //  System.out.println(n);
                if(map2.get(col)[1]==m) return i;

            }
            else{
                map2.put(col,new int[2]);
                map2.get(col)[1]++;
                if(map2.get(col)[1]==m) return i;


            }
            
        }

        return -1;
        
    }
}