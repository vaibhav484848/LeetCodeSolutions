class Solution {
    int mod=1000000007;

    long[] fact;
    long[] invFact;


    private void precomputeFactorials(int maxN) {
        fact = new long[maxN + 1];
        invFact = new long[maxN + 1];

        fact[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }

        invFact[maxN] = modExp(fact[maxN], mod - 2, mod); // Fermat's Little Theorem
        for (int i = maxN - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % mod;
        }
    }

    // Modular exponentiation
    private long modExp(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    private long nCr(int n, int r) {
        if (r > n) return 0;
        return (fact[n] * invFact[r] % mod * invFact[n - r] % mod) % mod;
    }

    // public int nCr(int n, int r) {
    //     if (r > n) return 0;
    //     if (r == 0 || r == n) return 1; 

    //     r = Math.min(r, n - r); 
    //     int result = 1;

    //     for (int i = 0; i < r; i++) {
    //         result = result * (n - i) / (i + 1);
    //     }

    //     return result;
    // }
    public int minMaxSums(int[] nums, int k) {

        int n=nums.length;


        precomputeFactorials(n);
        Arrays.sort(nums);

        long sum=0;

        for(int j=1;j<=k;j++){
            for(int i=0;i<n;i++){
                if(j==1) sum+= (2L*nums[i])%mod;
                else{
                    long ways=nCr(n-i-1,j-1);
                    sum= (sum%mod+(ways*nums[i])%mod)%mod;
                }

            }
        }

        for(int j=2;j<=k;j++){
            for(int i=n-1;i>=1;i--){
                
                
                    long ways=nCr(i,j-1);
                    sum= (sum%mod+(ways*nums[i])%mod)%mod;
                

            }
        }

        return (int)sum;


        
    }
}