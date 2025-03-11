class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int l=0,r=1;
        int n=colors.length;

        int[] newColors=new int[n+k-1];
        for(int i=0;i<n+k-1;i++){
            newColors[i]=colors[i%n];
        }

        // System.out.println(Arrays.toString(newColors));

        int count=0;

        while(r<newColors.length){
            if(newColors[r]==newColors[r-1]){
                l=r;
            }

            if(r-l+1==k) {
                count++;
                l++;
            }
            r++;
        }

        return count;
    }
}