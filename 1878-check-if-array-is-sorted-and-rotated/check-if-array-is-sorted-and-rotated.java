class Solution {
    void rev(int[] arr,int i,int j){

        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;j--;
        }
        
    }
    public boolean check(int[] nums) {

        int n=nums.length;

        int [] arr=Arrays.copyOf(nums,n);

        Arrays.sort(arr);

        if(Arrays.equals(arr,nums)) return true;

        for(int i=1;i<n;i++){
            int j=1;
            rev(arr,0,n-j-1);
            rev(arr,n-j,n-1);
            rev(arr,0,n-1);

            // System.out.println(Arrays.toString(arr));

            if(Arrays.equals(arr,nums)) return true;
        }

        return false;
        
    }
}