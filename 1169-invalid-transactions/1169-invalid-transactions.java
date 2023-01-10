class Solution {
    public List<String> invalidTransactions(String[] transaction) {
        String[][] trans = new String[transaction.length][4];
        for(int i = 0; i < transaction.length; i++){
            trans[i] = transaction[i].split(",");
        }
        
        Arrays.sort(trans, (a,b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));
               
        // for(String[] t: trans){
        //     System.out.println(Arrays.toString(t));
        // }
        
        List<String> invalid = new ArrayList<>();
        
        for(int i = 0; i < trans.length; i++){
            if(Integer.parseInt(trans[i][2]) <= 1000){
                for(int j = 0; j < trans.length; j++){
                    if(Math.abs(Integer.parseInt(trans[i][1]) - Integer.parseInt(trans[j][1])) <= 60 && trans[i][0].equals(trans[j][0]) && !trans[i][3].equals(trans[j][3])){
                        invalid.add(String.join(",", trans[i]));
                        break;
                    }
                }
            }else{
                invalid.add(String.join(",", trans[i]));
            }
        }
        
        return invalid;        
    }
}