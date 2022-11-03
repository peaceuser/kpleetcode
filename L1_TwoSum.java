import java.util.HashMap;
import java.util.Map;

public class L1_TwoSum {
    public static void main(String args[]) {
        L1_Solution sol = new L1_Solution();
        int[] res1 = sol.twoSum(new int[]{1, 2, 5, 6, 7, 8, 9}, 9); // will return index of elements that forms 2 sum
        System.out.print(res1[0] + " " + res1[1]);
    }
}

class L1_Solution {

    public int[] twoSum(int[] a, int target) {

       // o(N^2) complexity
      /*  for(int i=0; i<nums.length;i++){
          for(int j=i+1;j<nums.length;j++){
              if(nums[i]+nums[j]==target){
                  return new int[]{i,j};
              }
          }
      }*/
        //o(n) complexity

        //create a map
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<a.length;i++){

            //check if map contains target- current item if yes we found the result
            if(map.containsKey(target-a[i])){
                return new int[]{map.get(target-a[i]),i};
            }
            //put current item in map
            map.put(a[i],i);
        }
        return null;
    }
}