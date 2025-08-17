class Solution {
public:
    int check(int n,int m,int k){
        int l=2*k+1;
        int b=2*k+1;

        int lT=(m+l-1)/l;
        int bT=(n+b-1)/b;

        return lT*bT;
    }
    int minSensors(int n, int m, int k) {
        

        

        return check(n,m,k);

       
    }
};