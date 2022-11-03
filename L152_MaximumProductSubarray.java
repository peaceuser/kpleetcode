public class L152_MaximumProductSubarray {
    public static void main(String args[]) {
        L152_Solution sol = new L152_Solution();
        int res1 = sol.maxProduct(new int[]{2,3,-2,4});
        System.out.print(res1);
    }
}

class L152_Solution {

    public int maxProduct(int[] a) {
        int n = a.length;
        //create 2 variables to maintain negative product and positive product
        // since -x*-y = xy it is required to maintain smaller product
        int minProd=1;
        int maxProd=1;
        int result = a[0];

        for(int i=0;i<n;i++){
            //if we found a 0 then reset the min max prod start again
            if(a[i]==0){
                minProd=1;
                maxProd=1;
            }
            else
            {
                // get current min and max temp
                int minTemp = a[i]*minProd;
                int maxTemp = a[i]*maxProd;
                // comparing with current number a[i] to ensure continuity of sub array
                minProd = Math.min(a[i],Math.min(minTemp,maxTemp));
                maxProd = Math.max(a[i],Math.max(minTemp,maxTemp));
                result = Math.max(result,maxProd); // here only max is used coz we need max product anyways
            }
            // incase if there is a 0 present with a following negative number
            // the min and maxproducts are going to be negative thus this step
            result = Math.max(a[i],result);
        }
        return result;

    }
}

