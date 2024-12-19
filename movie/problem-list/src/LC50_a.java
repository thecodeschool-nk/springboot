import java.util.Arrays;

public class LC50_a {
    public static void main(String[] args) {
       int []nums1 = {1,2,3,0,0,0};
       int []nums2 = {2,5,6};
       int m = 3;
       int n = 3;

       merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertIndex = m + n - 1;
        int first = m - 1;
        int second = n - 1;

        while (first >= 0 && second >= 0) {
            if (nums2[second] > nums1[first]) {
                nums1[insertIndex--] = nums2[second--];
            } else {
                nums1[insertIndex--] = nums1[first--];
            }
        }

        while (second >= 0) {
            nums1[insertIndex--] = nums2[second--];
        }

        Arrays.stream(nums1).forEach(System.out::println);
    }
}
