class Solution {
    public int calPoints(String[] ops) {
               ArrayList<Integer> records = new ArrayList<>();

        for(int i = 0; i < ops.length; i++){
            if(ops[i].equals("+")){
                records.add(records.get(records.size()-2) + records.get(records.size()-1));
            }else if (ops[i].equals("C")){
                records.remove(records.size()-1);
            }else if (ops[i].equals("D")){
                records.add(2*records.get(records.size()-1));
            }else{
                records.add(Integer.parseInt(ops[i]));
            }
        }
        int sum = 0;
        for(int i : records) sum += i;
        return sum; 
    }
}