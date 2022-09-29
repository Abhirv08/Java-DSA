class Pair implements Comparable<Pair>{
    int element, diff;

    Pair(int element, int diff){
        this.element = element;
        this.diff = diff;
    }

    @Override
    public int compareTo(Pair o) {
        return this.diff == o.diff? this.element - o.element : this.diff - o.diff;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        
        int index = bs(arr, x);
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int left = index;
        while(left >= 0){
            pq.add(new Pair(arr[left], Math.abs(arr[left] - x)));
            left--;
        }

        int right = index+1;
        while(right < arr.length){
            pq.add(new Pair(arr[right], Math.abs(arr[right] - x)));
            right++;
        }

        while(k > 0){
            ans.add(pq.remove().element);
            k--;
        }
        
        Collections.sort(ans);
        return ans;
    }
    
    private int bs(int[] arr, int target){
        if(target < arr[0]){
            return -1;
        }
        int start = 0, end = arr.length - 1;
       
        while(start < end){
            int mid = start + (end - start)/2;
            
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            } 
        }
        
        return start;
    }
    
}