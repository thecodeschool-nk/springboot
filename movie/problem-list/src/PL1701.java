class PL1701 {
    public static void main(String[] args) {
        int [][] input = {{1,2}, {2,5}, {4,3}};
//        int [][] input = {{5,2}, {5,4}, {10,3},{20,1}};
        System.out.println(averageWaitingTime(input));
    }
    public static double averageWaitingTime(int[][] customers) {
        if (customers == null) 
            return 0.0;

        double totalWaitingTime = 0;
        int currentTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int orderTime = customer[1];

            currentTime = Math.max(currentTime, arrivalTime) + orderTime;

            totalWaitingTime += currentTime - arrivalTime;
        }

        return totalWaitingTime / customers.length;
    }
}