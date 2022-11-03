import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L238_ProductOfArrayExceptSelf {
    public static void main(String args[]) {
        L238_Solution sol = new L238_Solution();
        int[] res1 = sol.productExceptSelf(new int[]{1, 2, 3,4}); // will return index of elements that forms 2 sum
        Arrays.stream(res1).forEach(a-> System.out.print(a + ", "));

        System.out.println();
    }
}

class L238_Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod[] = new int[n];
        Arrays.fill(prod,1);
        int temp = 1;
        for(int i=1; i < n;i++){
            temp = nums[i-1] *temp;
            prod[i] =  prod[i] *temp;


        } Arrays.stream(prod).forEach(a-> System.out.print(a + ", "));

        System.out.println();

        temp = 1;
        //start with n-2 coz we have calculated element at index n-1 and element at 0 is yet to be calculated

        for(int i=n-2; i >= 0;i--){
            temp = nums[i+1] *temp;
            prod[i] =  prod[i] *temp;

        }

        return prod;
    }
}