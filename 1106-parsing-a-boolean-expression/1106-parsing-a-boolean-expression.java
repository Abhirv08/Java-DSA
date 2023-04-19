class Solution {
    public boolean parseBoolExpr(String exp) {
        int[] start = new int[1];
        char ch = exp.charAt(start[0]);
        start[0]++;
        
        if(ch == '&'){
            return parseAnd(exp, start);
        }else if(ch == '|'){
            return parseOr(exp, start);
        }
        return parseNot(exp, start);
    }
    
    private boolean parseAnd(String exp, int[] start){
        boolean op = true;
        while(exp.charAt(start[0]) != ')'){
            char ch = exp.charAt(start[0]);
            if(ch == 'f'){
                op = false;
            }else if(ch == '&'){
                start[0]++;
                boolean val = parseAnd(exp, start);
                op &= val;
            }else if(ch == '|'){
                start[0]++;
                boolean val = parseOr(exp, start);
                op &= val;
            }else if(ch == '!'){
                start[0]++;
                boolean val = parseNot(exp, start);
                op &= val;
            }
            start[0]++;
        }
        
        return op;
    }
    
    private boolean parseOr(String exp, int[] start){
        boolean op = false;
        while(exp.charAt(start[0]) != ')'){
            char ch = exp.charAt(start[0]);
            if(ch == 't'){
                op = true;
            }else if(ch == '&'){
                start[0]++;
                boolean val = parseAnd(exp, start);
                op |= val;
            }else if(ch == '|'){
                start[0]++;
                boolean val = parseOr(exp, start);
                op |= val;
            }else if(ch == '!'){
                start[0]++;
                boolean val = parseNot(exp, start);
                op |= val;
            }
            start[0]++;
        }
        
        return op;
    }
    
    private boolean parseNot(String exp, int[] start){
        boolean op = true;
        while(exp.charAt(start[0]) != ')'){
            char ch = exp.charAt(start[0]);
            if(ch == 'f'){
                op = false;
            }else if(ch == '&'){
                start[0]++;
                boolean val = parseAnd(exp, start);
                op &= val;
            }else if(ch == '|'){
                start[0]++;
                boolean val = parseOr(exp, start);
                op &= val;
            }else if(ch == '!'){
                start[0]++;
                boolean val = parseNot(exp, start);
                op &= val;
            }
            start[0]++;
        }
        
        return !op;
    }
}