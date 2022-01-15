// Q. Recently Air India opened its flight booking and received a lot of family group bookings. Overall there are N flights labelled from 1 to N. The flights operation manager of
//    Air India received an array of flights bookings details "FltDtls", where FltDtls[i] = [startFltNo, endFltNo, numSeats], denoting that each flight in range from "startFltNo"
//    to "endFltNo"(inclusive) have "numSeats" number of seats booked.
//    Now the flight's operation manager wants to know how many seats have been booked for each flight. So you, being a friend of his, help him to find the number of seats booked
//    in each flight starting from 1 to N.

// Input 1
// N = 4, P(array size) = 3, A = [[1,2,5],[2,3,6],[1,3,12]]
// Output
// [17, 23, 18, 0]

// Input 2
// N = 5, P(array size) = 3, A = [[1,3,20],[2,5,10],[1,2,7]]
// Output
// [27,37,30,10,10]

// Code
static int[] flights(int[][] data, int N){
        int[] ans = new int[N];
        int num = 1;
        while (num <= N){
            int count = 0;
            for (int i = 0; i < data.length; i++) {
                if (num >= data[i][0] && num <= data[i][1]){
                    count += data[i][2];
                }
            }
            ans[num-1] = count;
            num++;
        }
        return ans;
    }
