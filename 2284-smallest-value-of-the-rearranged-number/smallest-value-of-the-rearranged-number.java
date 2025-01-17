class Solution {
    long ans(Character[] arr){
        int flag=0;
        if(arr[arr.length-1]=='-'){
            flag =1;
        }
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<arr.length-flag;i++){
            sb.append(arr[i]);
        }

        long num=Long.parseLong(sb.toString());

        if(flag==1) return -num;
        return num;

    }
    public long smallestNumber(long num) {
        
        String s=""+num;

        char[] arrr=s.toCharArray();
        Character[] arr = new Character[arrr.length];
        for (int i = 0; i < arrr.length; i++) {
            arr[i] = arrr[i];
        }

        if(num>0)Arrays.sort(arr);
        else{
            Arrays.sort(arr,(a,b)->{
                return Character.compare(b,a);
            });
        }

        int n=arr.length;

        int i=0;

        while(i<n && arr[i]=='0'){
            i++;
        }
        if(i==0 || i==n) {
            return ans(arr);

        }

        else{
            char temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
        }

        return ans(arr);



    }
}