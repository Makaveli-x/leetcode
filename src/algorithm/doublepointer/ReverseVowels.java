package algorithm.doublepointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * EASY
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class ReverseVowels {

    /**
     *
     * 为什么是 left <= right
     * 当输入字符串长度为 2 时，如果使用 left < right, 会导致输出结果只有 1 个字符
     *
     * Time: O(1), Space O(1)
     *
     *
     * @param s
     * @return
     */
    public String doublePointer(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] charArray = new char[s.length()];
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!vowels.contains(leftChar)) {
                charArray[left++] = leftChar;
            } else if (!vowels.contains(rightChar)) {
                charArray[right--] = rightChar;
            } else {
                charArray[left++] = rightChar;
                charArray[right--] = leftChar;
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
//        char[] chars = "abc".toCharArray();
//        String s = String.copyValueOf(chars);
//        System.out.println(s);
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.doublePointer("ab"));

    }
}
