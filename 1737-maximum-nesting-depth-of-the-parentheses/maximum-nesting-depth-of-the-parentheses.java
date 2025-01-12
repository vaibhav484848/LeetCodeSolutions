class Solution {
    public int maxDepth(String s) {

        int balance=0;
        int maxBalance=0;

        int n=s.length();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                balance++;
                maxBalance=Math.max(maxBalance,balance);
            }
            else if(ch==')'){
                balance--;
            }
        }

        return maxBalance;
        
    }
}