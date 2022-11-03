public class L4_MedianOfTwoSortedArrays {

    public static void main(String args[]) {
        L4_Solution sol = new L4_Solution();
     //   double res = sol.findMedianSortedArrays_linear(new int[]{1, 2, 5, 6, 7, 8, 9}, new int[]{2, 6, 4, 8, 9});
       double res1 = sol.findMedianSortedArrays_BinarySearch(new int[]{1, 2, 5, 6, 7, 8, 9}, new int[]{2, 6, 4, 8, 9});
        System.out.print(res1);
    }

}

class L4_Solution {
    public double findMedianSortedArrays_linear(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums = new int[l1 + l2];
        int i = 0, j = 0;
        int k = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
                k++;
            }
            else {
                nums[k] = nums2[j];
                k++;
                j++;
            }
        }
        while (i < l1) {
            nums[k] = nums1[i];
            k++;
            i++;
        }

        while (j < l2) {
            nums[k] = nums2[j];
            k++;
            j++;
        }

        if ((l1 + l1) % 2 == 0) {
            return ((float) nums[(l1 + l2 - 1) / 2] + (float) nums[(l1 + l2) / 2]) / (float) 2;
        } else 
            return (float) nums[(l1 + l2 - 1) / 2];
    }

    public double findMedianSortedArrays_BinarySearch(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

       // This is my iterative solution using binary search. The main idea is to find the approximate location of the median and compare the elements around it to get the final result.
        //After binary search, we get the approximate location of median. Now we just need to compare at most 4 elements to find the answer. This step is O(1).

           //     the same solution can be applied to find kth element of 2 sorted arrays.

        //do binary search. suppose the shorter list is A with length n. the runtime is O(log(n)) which means no matter how large B array is,
        // it only depends on the size of A. It makes sense because if A has only one element while B has 100 elements,
        // the median must be one of A[0], B[49], and B[50] without check everything else. If A[0] <= B[49], B[49] is the answer;
        // if B[49] < A[0] <= B[50], A[0] is the answer; else, B[50] is the answer.
        if (l1 > l2) {
            return findMedianSortedArrays_BinarySearch(nums2, nums1);
        }

        int total = l1 + l2;

        int left = 0;
        int right = l1;

        var result = 0.0;

        while (left <= right) {
            int mid1 = left + (right - left) / 2; //  l1=4 l2=6  then mid1 =2
            int mid2 = (total+1)/2 - mid1;  // total len - mid mid2= 3 from (11/2-2)

            // get the four points around possible median
            int left1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int right1 = (mid1 < l1) ? nums1[mid1] : Integer.MAX_VALUE;
            int left2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right2 = (mid2 < l2) ? nums2[mid2] : Integer.MAX_VALUE;

            // partition is correct
            if (left1 <= right2 && left2 <= right1) {
                // even
                if (total % 2 == 0) {
                    result =
                            (Math.max(left1, left2) + Math.min(right1, right2)) /
                                    2.0;
                    // odd
                } else {
                    result = Math.max(left1, left2);
                }
                break;
            }
            // partition is wrong (update left/right pointers)
            else if (left1 > right2) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        return result;
    }
}

