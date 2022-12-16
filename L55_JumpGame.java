public class L55_JumpGame {

    /*
    55. Jump Game (Medium)

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
     */
    public static void main(String args[]) {
        L55_Solution sol = new L55_Solution();
        boolean res = sol.canJump(new int[]{2,3,1,1,4}); // will return index of elements that forms 2 sum
        System.out.print(res);
    }
}

class L55_Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        //since we want to reach n-1 it is the goal
        int goal = n-1;
        // we start with the number that is just before n-1 that is n-2 and go till 0
        for(int i = n-2; i>=0;i--){

            //for n-2 nums[n-2] we want it to be at least 1 so that it can reach goal
            // goal is n-1
            // (n-1) - i (first val is n-2) i.e. 1
            // if( nums[n-2] ==1 then we will update goal by i i.e. n-2 for first case
            if(nums[i]>=goal-i) goal = i;
        }
        //if we reached first element then we reached the goal
        return goal==0;
    }

}
