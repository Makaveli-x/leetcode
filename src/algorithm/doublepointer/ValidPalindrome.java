package algorithm.doublepointer;

/**
 * Easy
 *
 * 什么是回文字符串？
 *
 * 所谓的回文字符串，是指具有左右对称特点的字符串，例如 "abcba" 就是一个回文字符串。
 * 使用双指针可以很容易判断一个字符串是否是回文字符串：令一个指针从左到右遍历，一个指针从右到左遍历，
 * 这两个指针同时移动一个位置，每次都判断两个指针指向的字符是否相同，如果都相同，字符串才是具有左右对称性质的回文字符串。
 *
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class ValidPalindrome {

    /**
     *
     * 左右指针分别从两头开始移动，如果遇到两个字符不想等的情况
     * 需要判断是删除左边指针的元素还是右边指针的元素。所以可以尝试两种删除的情况
     * 只要有一边满足需求即可。
     *
     *
     * @param s
     * @return
     */
    public boolean doublePointer(String s) {
        if (null == s) {
            return false;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 判断字符串是否是回文串
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
//        System.out.println(validPalindrome.doublePointer("abdbca"));
        System.out.println(validPalindrome.doublePointer("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

}
