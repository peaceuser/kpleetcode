public class L91_DecodeWays {
    public static void main(String args[]) {
        L91_Solution sol = new L91_Solution();
        int res1 = sol.numDecodings("226"); // will return index of elements that forms 2 sum
        System.out.print(res1);
    }
}

class L91_Solution {
    public int numDecodings(String s) {
        int back2 = 1;
        int back1 = s.charAt(0) == '0' ? 0 : 1;
        int cur= back1;
        for(int i=2;i<s.length()+1;i++){
            cur =0;
            char ob = s.charAt(i-1);
            char tb = s.charAt(i-2);

            if(ob != '0'){
                cur = cur+back1;
            }
            if(tb == '1' || (tb == '2' && ob < '7')){
                cur = cur+back2;
            }
            back2= back1;
            back1= cur;


        }
        return cur;
    }
}


