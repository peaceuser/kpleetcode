import java.util.HashMap;
import java.util.Map;

public class L217_ContainsDuplicate {
    public static void main(String args[]) {
        L217_Solution sol = new L217_Solution();
        boolean res = sol.containsDuplicate(new int[]{1,2,3,1}); // will return index of elements that forms 2 sum
        System.out.print(res);
    }
}

class L217_Solution {

    public boolean containsDuplicate(int[] a) {
        //O(n) Complexity
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                return true;
            }
            map.put(a[i],i);
        }
        return false;
    }
}