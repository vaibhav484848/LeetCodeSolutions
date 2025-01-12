class Solution {
    public String minRemoveToMakeValid(String s) {

        int balance=0;

        int n=s.length();


        StringBuilder sb=new StringBuilder(s);

        

        int index=-1;

        for(int i=0;i<n;i++){
            char ch=sb.charAt(i);
            if(ch=='('){
                
                balance++;
                index=i;
    
            }
            else if(ch==')'){
                if(balance>=1){
                 
                    balance--;
                }
                else {
                    sb.setCharAt(i,'*');
                }
            }
        
        }
       
       
        int i=index;

        
        while(balance>0 && i>=0){
            if(sb.charAt(i)=='('){
                balance--;
                sb.setCharAt(i,'*');
            }
            i--;
        }
       

        
        StringBuilder finalAns=new StringBuilder("");

        for(int ii=0;ii<n;ii++){
            char ch=sb.charAt(ii);
            if(ch!='*') finalAns.append(ch);
        }

        return finalAns.toString();
        
    }
}