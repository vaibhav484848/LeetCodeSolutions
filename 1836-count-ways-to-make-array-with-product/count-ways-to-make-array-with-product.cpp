class Solution {
public: 
    long long mod = 1e9 + 7;

    vector<long long> fact;
    vector<long long> invFact;

    long long binPow(long long a, long long b){
        long long res = 1;
        while(b > 0){
            if(b & 1){
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    void precomputeFactorials(long long n) {

        fact.resize(n + 1);
        invFact.resize(n + 1);

        fact[0] = 1;
        for(long long i = 1; i <= n; i++){
            fact[i] = (fact[i - 1] * i) % mod;
        }

        invFact[n] = binPow(fact[n], mod - 2);
        for(long long i = n - 1; i >= 0; i--){
            invFact[i] = (invFact[i + 1] * (i + 1)) % mod;
        }
    }

    void calc(map<int,int>& mp,int n){
        for(int i=2;i*i<=n;i++){
            int count=0;
            if(n%i==0){
                while(n%i==0){
                    count++;
                    n/=i;
                }
                // primeF[i]=count;
                mp[i]=count;
            }
        }
        if(n!=1){
            mp[n]=1;
        }
    }
    vector<int> waysToFillArray(vector<vector<int>>& queries) {

       

        vector<int>v;

        int n=queries.size();

        precomputeFactorials(1e5+1);

        for(int i=0;i<n;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            
            // vector<int>primeFact(b+1,0);
            map<int,int>primeFact;
            calc(primeFact,b);

            long long fans=1;

            for(auto it:primeFact){

                int prime=it.first;
                int times=it.second; 
                
                if(times!=0){
                    int bars=times;
                    
                    long long ans=(fact[bars+a-1]*(invFact[a-1]))%mod;
                    ans=(ans*invFact[bars])%mod;
                    fans=(fans*ans)%mod;
                }
            }
            v.push_back((int)fans);
            
        }
       

        return v;

        
    }
};

// 2^3

// 2^2*3

// 12

// 1 0 
// 0 1 

// 1 1 0 0 
// 1 0 1 0
// 1 0 0 1
// 0 1 1 0
// 0 1 0 1
// 0 0 1 1
// 0 0 0 2
// 0 0 2 0 
// 0 2 0 0
// 2 0 0 0