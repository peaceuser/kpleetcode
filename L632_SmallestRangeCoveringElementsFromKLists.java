import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class L632_SmallestRangeCoveringElementsFromKLists {

    public static void main(String args[]) {
        L632_Solution sol = new L632_Solution();
     //   double res = sol.findMedianSortedArrays_linear(new int[]{1, 2, 5, 6, 7, 8, 9}, new int[]{2, 6, 4, 8, 9});
        int[] res1 = sol.smallestRange(Arrays.asList(Arrays.asList(4,10,15,24,26),Arrays.asList(0,9,12,20),Arrays.asList(5,18,22,30)));
        System.out.print(res1[0] + " " + res1[1]);
    }

}

class L632_Solution {

    // creating a class to maintain array index with value since we have K lists
    // row meaning which List in K lists
    // col represents index within the list
    // value corresponds to actual value of the list

    class Pair implements Comparable<Pair> {
        int val;
        int row;
        int col;

        public Pair(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        //since we are creating a new class, writing a compareTo here to keep PQ declaration clean
        public int compareTo(Pair other) {
            return Integer.compare(this.val,other.val);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        //create a PQ since we always need a sorted list of K elements
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //this will represent the end of the range we want to return
        int max = Integer.MIN_VALUE;

        // add first element of each lit in PQ
        // which will sort it based on value
        for(int i=0; i<nums.size(); i++) {
            pq.add(new Pair(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }
        // here we have PQ of size K and having first element of each list in ascending order
        int start = 0;
        int end = 0;
        int range = Integer.MAX_VALUE;

        //we loop thru pq till one of the list from input fully traversed
        while(pq.size() == nums.size()) {
            //take the smallest pair (list, value and index of value)
            Pair pair = pq.remove();

            //get current range since PQ stores everything in ascending order it will return smallest number
            // max was populated with largest value in loop above and will contain max value as we keep adding new elements below
            int currentRange = max - pair.val;

            //if current range is smaller than existing one update start and end
            if(currentRange < range) {
                range = currentRange;
                start = pair.val;
                end = max;
            }
            // we move to next element on the list which had the minimum element here so pair.col will be +1
            // checking if col is not the last element
            // if we have reached last element of any of the list we will not add new element to PQ and while condition will break the loop
            // we can explicitly break loop in else condition if we had used while(!q.isEmpty()) above
            if(pair.col < nums.get(pair.row).size() - 1) {
                pq.add(new Pair(nums.get(pair.row).get(pair.col + 1), pair.row, pair.col + 1));
                max = Math.max(max, nums.get(pair.row).get(pair.col + 1));
            }
        }

        return new int[]{start, end};
    }
}

