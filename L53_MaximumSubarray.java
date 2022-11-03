import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class L53_MaximumSubarray {

    public static void main(String args[]) {
        L53_Solution sol = new L53_Solution();
        int res1 = sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.print(res1);
    }

}

class L53_Solution {

    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            maxSoFar = Math.max(maxSoFar, sum); // is sum is greater than res then update res
            sum = sum < 0 ? 0 : sum; // is sum is less than 0 better start fresh
        }
        return maxSoFar;
    }
}

