class Solution {
public:
    long long totalScore(int hp, vector<int>& damage, vector<int>& requirement) {
        int n=damage.size();
        long long fans=0,count=0;
        int temp=hp;

        priority_queue<
            pair<int,int>,
            vector<pair<int,int>>,
            greater<pair<int,int>>
        > pq;

        for(int i=0;i<n;i++){
            if(temp-damage[i] >=requirement[i]){
                count++;
                
            }
            else{
                if(i!=0)
                pq.push({requirement[i]-(temp-damage[i]),i});
            }
            temp-=damage[i];
        }
        fans=count;
        
        long long distri=0;
        
        long long prevS=count;

        for(int i=1;i<n;i++){
            long long score=prevS;
            

            if(hp-damage[i-1]>=requirement[i-1]){
                score--;
            }
            
            distri+=damage[i-1];
            
            while(pq.size()>0){
                pair p=pq.top();

                int ele=p.first;
                int idx=p.second;
               

                if(idx<i) {
                    pq.pop();
                    continue;
                }

                if(ele<=distri){
                    score++;
                }
                else{
                    break;
                }
                pq.pop();
            }
            prevS=score;
            fans+=score;
        }
        return fans;

    }
};