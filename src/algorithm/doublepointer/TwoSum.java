package algorithm.doublepointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * EASY
 *
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {


    /**
     * 左右双指针，由于题目给出的是升序数组，所以当
     * 两数和大于目标值时，向左移动右指针
     * 两数和小于目标值时，向右移动左指针
     *
     * Time：O(n), Space: O(1)
     *
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] doublePointer(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int leftValue = numbers[left];
            int rightValue = numbers[right];
            if (target == leftValue + rightValue) {
                return new int[]{left + 1, right + 1};
            } else if (target > leftValue + rightValue) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
    /**
     *
     * 利用 Map 保存访问过的值
     * Time：O(n), Space: O(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] usingMap(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int[] result = new int[2];
        Map<Integer, Integer> valueToIdxMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer leftIdx = valueToIdxMap.get(target - numbers[i]);
            if (null != leftIdx) {
                result[0] = leftIdx;
                result[1] = i + 1;
                break;
            }
            valueToIdxMap.put(numbers[i], i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.usingMap(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum.doublePointer(new int[]{2, 7, 11, 15}, 9)));
    }
}
