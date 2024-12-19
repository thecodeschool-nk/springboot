
/*
https://leetcode.com/problems/maximum-binary-string-after-change/?source=submission-ac
 */
public class PL1702 {

    public static void main(String[] args) {
        String binaryString = "000110";

        System.out.println(maximumBinaryString(binaryString));

    }

    public static String maximumBinaryString(String binary) {

        int zeros = 0;
        char[] strArr = binary.toCharArray();
        for (int i=0; i<strArr.length; i++) {
            if ('0' == strArr[i]) {
                zeros++;
            }
        }

        StringBuilder ans = new StringBuilder("1".repeat(binary.length()));

        for (int i=0; i<strArr.length; i++) {
            if (strArr[i] == '0') {
                ans.setCharAt(i + zeros - 1, '0');
                return ans.toString();
            }
        }

        return ans.toString();
    }
}
