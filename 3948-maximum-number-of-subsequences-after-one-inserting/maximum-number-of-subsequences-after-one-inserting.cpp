
class Solution {
public:
    
    long long numOfSubsequences(string s) {
        int n=s.length();
        int prefixL[200000]={0};
        // int suffixC[200000]={0};
        int suffixT[200000]={0};

        if(s[0]=='L') prefixL[0]=1;
        for(int i=1;i<n;i++){
            char ch=s[i];
            if(ch=='L'){
                prefixL[i]=1+prefixL[i-1];
            }
            else{
                prefixL[i]=prefixL[i-1];
            }
        }
        if(s[n-1]=='T') suffixT[n-1]=1;
       

        for(int i=n-2;i>=0;i--){
            char ch=s[i];
            
                if(ch=='T'){
                suffixT[i]=1+suffixT[i+1];
                }
                else{
                    suffixT[i]=suffixT[i+1];
                }

            
        }

        
        long long fans=0;

        long long pos1=0;
        long long pos2=0;
        long long pos3=0;

        long long maxPS=0;

        for(int i=0;i<n;i++){
            long long maxm=INT_MIN;
            
            char ch=s[i];

            maxPS=max({maxPS,1ll*prefixL[i]*suffixT[i]});

            if(ch=='C'){
                pos1+=1l*(prefixL[i]+1)*suffixT[i];
                pos2+=1l*(prefixL[i])*suffixT[i];
                pos3+=1l*(prefixL[i])*(suffixT[i]+1);
                
            }
            
            
        }
        
        fans=max({pos1,pos2+maxPS,pos3});

        return fans;

    }
};