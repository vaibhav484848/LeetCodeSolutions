class NumberContainers {

    HashMap<Integer,Integer> map;

    HashMap<Integer,TreeSet<Integer>> numbers=new HashMap<>();

    public NumberContainers() {
        map=new HashMap<>();
    }
    
    public void change(int index, int number) {
        // map.put(number,Math.min(map.getOrDefault(number,Integer.MAX_VALUE),index));

        if(map.containsKey(index)){
            int ele=map.get(index);
            numbers.get(ele).remove(index);
        }
        
        map.put(index,number);
        numbers.putIfAbsent(number,new TreeSet<>());
        numbers.get(number).add(index);
    }
    
    public int find(int number) {
        
        if(numbers.containsKey(number)){
            return (numbers.get(number).size()!=0)?numbers.get(number).first():-1;
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