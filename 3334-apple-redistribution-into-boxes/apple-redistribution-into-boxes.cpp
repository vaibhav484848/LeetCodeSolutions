class Solution {
public:
    int minimumBoxes(vector<int>& apple, vector<int>& capacity) {
        int n=apple.size();
        int m=capacity.size();

        int totalApple=0;

        for(int ele:apple){
            totalApple+=ele;
        }

        sort(capacity.begin(),capacity.end(),greater<int>());

        int space=0,countContainer=0;

        for(int ele:capacity){
            countContainer++;
            space+=ele;
            if(space>=totalApple){
                break;
            }
        }

        return countContainer;
    }
};