import java.util.Arrays;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return binarySearchInsert(nums, left, right, target);
    }

    public int binarySearchInsert(int[] nums, int left, int right, int target) {
        if (left > right) return right;
        int midIndex = (left + right) / 2;
        if (nums[midIndex] == target) return midIndex;
        if (nums[midIndex] > target) right = midIndex - 1;
        else left = midIndex + 1;

        return binarySearchInsert(nums, left, right, target);
    }
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        return bSearchMissingNumber(nums, left, right);
    }
    public int bSearchMissingNumber(int[] nums, int left, int right) {
        //       0 1 2 3 4 5 7 8 9
        //index: 0 1 2 3 4 5 6 7 8
        if (left == right) {
            if (left == nums[left]) return left + 1;
            else return left;
        }
        int midIndex = (left + right) / 2;
        if (midIndex != nums[midIndex]) right = midIndex;
        else left = midIndex + 1;
        return bSearchMissingNumber(nums, left, right);
    }
}
