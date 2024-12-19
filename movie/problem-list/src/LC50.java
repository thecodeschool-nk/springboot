import java.util.Arrays;

public class LC50 {
    public static void main(String[] args) {
       int []nums1 = {1,2,3,0,0,0};
       int []nums2 = {2,5,6};
       int m = 3;
       int n = 3;

       merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int first = nums1[j];
        int second = nums2[k];
        while (i < nums1.length) {
            if (first <= second && j < m) {
                nums1[i] = first;
                i++;
                j++;
                first = nums1[j];
            } else if (k < n) {
                nums1[i] = second;
                i++;
                k++;

                if (k < n) {
                    second = nums2[k];
                }
            }
        }

        Arrays.stream(nums1).forEach(System.out::println);
    }
}
