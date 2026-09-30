class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        /*
        1 4 5 9
        1 2 3 6

        1-occ
        4-occ

        1 2 4
        1 3 3


        0   1  2  3   4 
            s     ss

        */
        Arrays.sort(seats);
        Arrays.sort(students);

        int minMoves = 0;

        for(int i=0;i<seats.length;i++){
            minMoves += Math.abs(seats[i]-students[i]);
        }
        return minMoves;
    }
}