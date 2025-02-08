class NumberContainers {

    HashMap<Integer,Integer> map;

    HashMap<Integer,PriorityQueue<Integer>> numbers=new HashMap<>();

    public NumberContainers() {
        map=new HashMap<>();
    }
    
    public void change(int index, int number) {
        
        map.put(index,number);
        numbers.putIfAbsent(number,new PriorityQueue<>());
        numbers.get(number).add(index);
    }
    
    public int find(int number) {
        
        if(numbers.containsKey(number)){
            PriorityQueue<Integer> pq= numbers.get(number);
            
            while(pq.size()>0){
                int index=pq.peek();
                if(map.get(index)==number) return index;
                pq.remove();
            }
        }
        
        return -1;
        
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */