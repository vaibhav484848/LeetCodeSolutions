class Solution {
public:
// 00 true
//1 false
//10 ? in this n-1 should be even
    bool isOneBitCharacter(vector<int>& bits) {
        int n=bits.size();

        if(bits[n-1]==1) return false;
        if(n==1 || bits[n-2]==0) return true;

        int count=0;

        for(int i=n-2;i>=0;i--){
            if(bits[i]==0) break;
            if(bits[i]==1) count++;
        }

        return (count)%2==0;
    }
};