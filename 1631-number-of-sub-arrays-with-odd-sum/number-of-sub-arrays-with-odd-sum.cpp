class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        #define int long long
        int mod=1000000007;
        int ans=0;
        int sum=0;
        int evenSumCount=0;
        int oddSumCount=0;

        for(int i=0;i<arr.size();i++){
            sum+=arr[i];
            if(sum%2!=0){
                ans=(ans+1)%mod;
                ans= (ans+evenSumCount)%mod;
                oddSumCount++;
            }
            else{
                ans=(ans+oddSumCount)%mod;
                evenSumCount++;
            }
        }
        return ans;

        #undef int
        
    }
};