class Solution {
public:
    int maximizeSquareHoleArea(int n, int m, vector<int>& hBars, vector<int>& vBars) {
        sort(hBars.begin(),hBars.end());
        sort(vBars.begin(),vBars.end());

        int countV=1,countH=1,maxV=1,maxH=1;

        for(int i=1;i<vBars.size();i++){
            if(vBars[i]==2 || vBars[i]==m+2)continue;
            if(vBars[i]==vBars[i-1]+1) {
                countV++;
                maxV=max(countV,maxV);
            }
            else{
                countV=1;
            }
        }
        for(int i=1;i<hBars.size();i++){
            if(hBars[i]==2 || hBars[i]==n+2)continue;
            if(hBars[i]==hBars[i-1]+1) {
                countH++;
                maxH=max(countH,maxH);
            }
            else{
                countH=1;
            }
        }

        
        int minm=min({maxV+1,maxH+1});
        return minm*minm;
    }
};