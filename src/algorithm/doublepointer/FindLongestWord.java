package algorithm.doublepointer;

import java.util.Arrays;
import java.util.List;

/**
 * Medium
 *
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * 输出:
 * "apple"
 * 示例 2:
 *
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * 输出:
 * "a"
 * 说明:
 *
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class FindLongestWord {

    /**
     *
     * 题目重点 "该字符串可以通过删除给定字符串的某些字符来得到"。
     * 所以我们只需判断字典列表中的字符串 target 是否是源字符串的子串即可。
     * 可以利用两个指针，一个指向源字符串 s 的第一个字符。另一个指向目标字符串 target 的第一个字符，
     * 然后顺序移动两个指针，判断是否可以再源字符串中找到目标字符串中的所有字符即可。
     *
     *
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        if (null == s || null == d) {
            return "";
        }
        String result = "";
        for (String targetWord : d) {
            // 长度以及字母表中顺序判断
            if (targetWord.length() < result.length() || ((targetWord.length() == result.length()) && targetWord.compareTo(result) > 0)) {
                continue;
            }
            // 如果是子串，则比较其是否是最长且顺序最靠前
            if (isSubstring(s, targetWord)) {
                result = targetWord;
            }
        }
        return result;
    }

    /**
     *
     * 利用双指针判断目标字符串是否是源字符串的子串
     *
     *
     * @param source
     * @param target
     * @return
     */
    private boolean isSubstring(String source, String target) {
        int sourceIdx = 0, targetIdx = 0;
        while (sourceIdx < source.length() && targetIdx < target.length()) {
            if (source.charAt(sourceIdx) == target.charAt(targetIdx)) {
                targetIdx++;
            }
            sourceIdx++;
        }
        return targetIdx == target.length();
    }


    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        String result = findLongestWord.findLongestWord("abpcplea", Arrays.asList("a", "b", "c"));
        System.out.println(result);

    }



}
