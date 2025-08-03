class Solution {
public:
    int check(int mid,vector<int> arr){
        return mid==arr.size()-1 || arr[mid]>arr[mid+1];
    }
    int findPeakElement(vector<int> &arr) {
      int n=arr.size();

      int lo=0;
      int hi=n-1;

      int ans=n-1;

      while(lo<=hi){
        int mid=lo+(hi-lo)/2;

        if(check(mid,arr)==0){
            lo=mid+1;
        }
        else{
            ans=mid;
            hi=mid-1;
        }
      }
      return ans;


    }
};