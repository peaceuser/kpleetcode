import java.util.Arrays;

public class L300_LongestIncreasingSubsequence {
    public static void main(String args[]) {
        L300_Solution sol = new L300_Solution();
        int res1 = sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}); // will return index of elements that forms 2 sum
        System.out.print(res1);
    }
}

class L300_Solution {
    public int lengthOfLIS(int[] nums) {
        // if length is 0 then
        if(nums==null || nums.length==0)
            return 0;

        //we keep longest increasing squence for each index in this
        int[] dp = new int[nums.length];
        // fill all by 1 means without even processing worstcase scenario is array is sorted in desc order
        Arrays.fill(dp,1);

        int result = 1;
        // iterate thru all numbs start from 1 coz a[0] will always be 1 since no prev numbers
        for(int i=1;i<nums.length;i++)
        {
            //we start with 0 and then stop at current number
            //magic here happens with the dp array that stores count of longest increasing subsequence for that entry
            // we start with first so if the previous one is smaller this will register that and we use it below in logic
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    // here i is the final one and j will be previous ones whose LIS is already calculated
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }

            }
            // result will be max of LIS from each max LIS
            result = Math.max(result,dp[i]);
        }


        return result;
    }

}
