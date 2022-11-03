import java.util.HashMap;
import java.util.Map;

public class L121_BestTimeToBuyAndSellStock {
    public static void main(String args[]) {
        L121_Solution sol = new L121_Solution();
        int res1 = sol.maxProfit(new int[]{7,1,5,3,6,4}); // will return index of elements that forms 2 sum
        System.out.print(res1);
    }
}


class L121_Solution {

    public int maxProfit(int[] a) {
        int max = 0;
        //n2 approach check max profit for each combination of i and j
        /*for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]-a[i]>max){
                    max = a[j]-a[i];
                }
            }
        }*/

        //O(n) approach where update min price when we find a price lower than current min price
        //max = max of (max , a[i] - minPrice) // getting max profit
        int minPrice = a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]<minPrice) //todays price is lower than what we had earlier better to take this price
                minPrice =a[i];
            else //todays price is higher prev price check if it beats our max profit by far
                max = Math.max(max,a[i]-minPrice);
        }
        return max;
    }
}