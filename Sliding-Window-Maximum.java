// Q. Given an array of integers A.  There is a sliding window of size B which is moving from the very left of the array to the very right. 
//   You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window. 

// Example: A= [1 3 -1 -3 5 3 6 7],B = 3.
//   Output : [3 3 5 5 6 7]

// CODE:
static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = 0;
        if(B >= A.size()){
            for(int i = 0; i<A.size(); i++){
                if(max < A.get(i)){
                    max = A.get(i);
                }
            }
            ans.add(max);
            return ans;
        }
        int l = 0;
        int r = 0;
        while(r < A.size()){
            if(max < A.get(r)){
                max = A.get(r);
            }
            if(r-l+1 < B){
                r++;
            }else if(r-l+1 == B){
                ans.add(max);
                if(max == A.get(l) && l+1 <A.size()){
                    max = A.get(l+1);
                    for(int i = l+2; i <= r; i++){
                        if(max < A.get(i)){
                            max = A.get(i);
                        }
                    }
                }
                r++;
                l++;
            }
        }
        return ans;
    }
