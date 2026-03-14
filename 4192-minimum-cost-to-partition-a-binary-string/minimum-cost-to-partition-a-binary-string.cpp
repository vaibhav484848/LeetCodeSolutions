class Solution {
public:

    vector<long>prefix;
    map<pair<int, int>, long long> dp;

    long long eC,fC;

    long long rec(int l,int r){

        if (dp.count({l, r})) return dp[{l, r}];

        long long len=r-l+1;

        int no1=prefix[r]-((l>0)?prefix[l-1]:0);

        long long cost=1e18;

        if(no1==0){
            cost=min(cost,fC);
        }
        else{
            cost=min(cost,len*no1*eC);
        }

       
        if((len%2)==0){
            int mid=(l+r)/2;
            cost=min(cost,rec(l,mid)+rec(mid+1,r));
        }

        return dp[{l,r}]=cost;
    }

   
    long long minCost(string s, int encCost, int flatCost) {
        eC=encCost;
        fC=flatCost;
        int n=s.size();
        prefix.assign(n,0);

        prefix[0]=(s[0]=='1')?1:0;

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1];
            if(s[i]=='1'){
                prefix[i]+=1;
            }
        }

        return rec(0,n-1);
    }
};


// Prefix Sum -> after that simple dp and base case will if odd then return 
// we will always have two ways to break the problem if even -> in half or don't break