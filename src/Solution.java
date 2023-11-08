import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        int i = 0;
        return findByRecursion(arr1, arr2, d, count, i);
    }
    public int findByRecursion(int[] arr1, int[] arr2, int d, int count, int i) {
        int countNum = 0;
        if (i == arr1.length) {
            return count;
        }
        for(int j = 0; j < arr2.length; j++) {
            if(Math.abs(arr1[i] - arr2[j]) <= d) {
                countNum++;
                break;
            }
        }
        if(countNum == 0) count++;
        return findByRecursion(arr1, arr2, d, count, ++i);
    }
    public int longestSquareStreak(int[] nums) {
        if (nums.length < 2) return -1;
        Arrays.sort(nums);
        List<Integer> numsList = new ArrayList<>();
        for(int num: nums) {
            numsList.add(num);
        }
        //numsList.addAll(Arrays.asList(nums));
        int count = 1;  //biến lưu trữ kết quả sau mỗi lần lặp để so sánh với maxResult
        int maxResult = 1;  //biến return kquả cao nhất
        int i = 0;  //biến index chạy từ đầu
        int iValue = nums[i];   //giá trị tại biến index
        return recursion(numsList, i,iValue, count, maxResult);
    }
    //2 3 4 6 8 16
    //2 3 6 9 16
    public int recursion(List<Integer> numsList, int i, int iValue, int count, int maxResult) {
        if (count > maxResult) {
            maxResult = count;
        }
        if (i == numsList.size()) {
            // if (count > maxResult) {
            //     maxResult = count;
            // }
            if (maxResult == 1) return -1;
            return maxResult;
        }
        count = 1; //sau mỗi lần đệ quy, thì count sẽ quay về 1
        int square = (int) Math.pow(iValue, 2);     //biến tính bình phương tại index i
        for(int j = i + 1; j < numsList.size(); ) {
            if (numsList.get(i) == numsList.get(j)) {
                numsList.remove(j);
                continue;
            }
            if (square == numsList.get(j)) {
                iValue = numsList.get(j);
                numsList.remove(j);
                count++;
            }
            else j++;
        }
        //i++;
        return recursion(numsList, i + 1, iValue, count, maxResult);
    }
}
