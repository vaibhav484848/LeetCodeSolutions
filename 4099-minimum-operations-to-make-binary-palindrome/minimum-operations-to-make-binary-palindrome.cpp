class Solution {
public:
    bool check(int n){
        int bits[32];
        int idx=0;

        int pos = 31 - __builtin_clz(n);

        while(n>0){
            bits[idx++]=n%2;
            n/=2;
        }
        int i=0,j=pos;
        while(i<j){
            if(bits[i++]!=bits[j--]) return false;
        }
        return true;
    }
    vector<int> minOperations(vector<int>& nums) {
        int n=nums.size();

        vector<int>fans(n,0);

        for(int i=0;i<n;i++){
            int ele=nums[i];

            int leftDist=INT_MAX;

            int left=ele;
            int right=ele;

            while(left>=1){
                if(check(left)) break;
                left--;
            }
            while(right<=100000){
                if(check(right)) break;
                right++;
            }
            int ans=min(abs(left-ele),abs(right-ele));
            fans[i]=ans;
        }

        return fans;
    }
};