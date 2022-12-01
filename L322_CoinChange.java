import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L322_CoinChange {
    public static void main(String args[]) {
        L322_Solution sol = new L322_Solution();
        int res1 = sol.coinChange(new int[]{1, 2, 5}, 11); // will return index of elements that forms 2 sum
        System.out.print(res1);
    }
}

class L322_Solution {
    public int coinChange(int[] coins, int amount) {
        // create a dp array to store minumim number of coins needed for each number which is prior to required amount
        // since array is 0 indexed and we want to  go till amount we create an array of size amount+1

        long[] dp = new long[amount+1];

        // since we want to return minumum coins fill up the array with max numbers as worst case
        // that our amount cannot be made up by coins and we will return -1
        Arrays.fill(dp,Integer.MAX_VALUE);

        //for 0 amount we ideally need no coin making it a base case
        dp[0]=0L;

        // loop thru all coins
        for(int coin:coins){
            // fill up the dp for all numbers with one coin at a time
            // in case we have coin valued at 1 dp would look like [1,2,3,4..11] for amount 11
            for(int amt=1;amt<=amount;amt++){
                //if the coin is larger than current amt we cannot do anything so coin should be smaller than current amt
                if(coin<=amt){
                    // since we want to optimize number of coins when second coin comes with value 2
                    // dp[2] will become min(2,dp[2-2])-> min(2,dp[0]+ 1) = 1
                    dp[amt] = Math.min(dp[amt],dp[amt-coin]+1);
                }
            }
        }
        // if our amount cannot be made up by coins it will have MAX_VALUE and we will return -1 or actual number
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int)dp[amount];
    }
}