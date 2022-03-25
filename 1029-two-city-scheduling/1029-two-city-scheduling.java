class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(Math.abs(a[0] - a[1]), Math.abs(b[0] - b[1])));

        int cityA = 0, cityB = 0, totalCost = 0, N = costs.length / 2;
        for (int i = costs.length - 1; i >= 0; i--) {
            int costA = costs[i][0], costB = costs[i][1];
            if (cityA == N) { // means N persons already sent to city A
                totalCost += costB;
            } else if (cityB == N) { // N persons already sent to city B
                totalCost += costA;
            }
            else {
                if (costA < costB) {
                    totalCost += costA;
                    cityA++;
                } else if (costA > costB) {
                    totalCost += costB;
                    cityB++;
                } else {  // d = 0 so we can take costA or costB as they are equal
                    totalCost += costA;
                }
            }
        }

        return totalCost;
    }
}