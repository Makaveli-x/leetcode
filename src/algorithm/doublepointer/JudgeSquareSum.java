package algorithm.doublepointer;

/**
 * Medium
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JudgeSquareSum {

    /**
     * 思路类似 #{@link TwoSum}
     *
     * 有两点小区别
     *
     * 1. 对于右指针初始值的选择：使用目标值开根号向下取整的值（2 = sqrt(5)）,而不是目标值减 1。
     * 2. 相同的元素可以使用两次，比如当目标值为 2 时，结果为 1 * 1 + 1 * 1，所以 while 判断为
     * left <= right 而不是 left < right。
     *
     * Time：O(sqrt(n)), Space: O(1)
     *
     * @param c
     * @return
     */
    public boolean doublePointer(int c) {
        int right = (int) Math.sqrt(c);
        int left = 0;
        while (left <= right) {
            int powSum = left * left + right * right;
            if (powSum == c) {
                return true;
            } else if (powSum < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println((int) Math.sqrt(5));
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.doublePointer(2));
    }
}
