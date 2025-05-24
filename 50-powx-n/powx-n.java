class Solution {
    double binPow(double x,long n){
       

        if(n==0 || x==1) return 1.0;
        if(n%2!=0) return x*binPow(x,n-1);
        else {
            double num=x*x;
            return binPow(num,n/2);
        }
    }
    public double myPow(double x, int n) {
        if(n<0){
            long num=n;
            return 1/(binPow(x,-num));
        }
        return binPow(x,n);
    }
}