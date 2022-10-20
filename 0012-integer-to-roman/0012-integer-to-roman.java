class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        
        int[] digits = new int[4];
        int i = 0;
        while(num > 0){
            int rem = num % 10;
            digits[i] = rem;
            i++;
            num /= 10;
        }
        
        ans.append(stringifyThousands(digits[3]));
        ans.append(stringifyHundreds(digits[2]));
        ans.append(stringifyTens(digits[1]));
        ans.append(stringifyOnes(digits[0]));       
        
        return ans.toString();
    }
    
    private String stringifyOnes(int num){
        if(num == 0){
            return "";
        }
        
        if(num == 5){
            return "V";
        }else if(num < 5){
            if(num == 4){
                return "IV";
            }else{
                String s = "";
                while(num-- > 0){
                    s += "I";
                }
                
                return s;
            }
        }else{
            if(num == 9){
                return "IX";
            }else{
                String s = "V";
                while(num-- > 5){
                    s += "I";
                }                
                return s;
            }
        }
    }
    
    private String stringifyTens(int num){
        if(num == 0){
            return "";
        }
        
        if(num == 5){
            return "L";
        }else if(num < 5){
            if(num == 4){
                return "XL";
            }else{
                String s = "";
                while(num-- > 0){
                    s += "X";
                }
                
                return s;
            }
        }else{
            if(num == 9){
                return "XC";
            }else{
                String s = "L";
                while(num-- > 5){
                    s += "X";
                }                
                return s;
            }
        }
    }
    
    private String stringifyHundreds(int num){
        if(num == 0){
            return "";
        }
        
        if(num == 5){
            return "D";
        }else if(num < 5){
            if(num == 4){
                return "CD";
            }else{
                String s = "";
                while(num-- > 0){
                    s += "C";
                }
                
                return s;
            }
        }else{
            if(num == 9){
                return "CM";
            }else{
                String s = "D";
                while(num-- > 5){
                    s += "C";
                }                
                return s;
            }
        }
    }
    
    private String stringifyThousands(int num){
        if(num == 0){
            return "";
        }
        
        String s = "";
        while(num-- > 0){
            s += "M";
        }
        
        return s;
    }
}