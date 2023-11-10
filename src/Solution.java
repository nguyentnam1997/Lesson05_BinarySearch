import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public int[] sortArrayByMergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int[] mergeSort(int[] nums, int left, int right) {
        //1. Chia ra
        if (left == right) {
            return new int[]{nums[left]};
        }
        int mid = left + (right - left) / 2;
        int[] arr1 = mergeSort(nums, left, mid);
        int[] arr2 = mergeSort(nums, mid + 1, right);

        //2. Trộn vào
        return merge(arr1, arr2);
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int[] result = new int[n];
        int i = 0, i1 = 0, i2 = 0;
        while (i < n) {
            if (i1 < arr1.length && i2 < arr2.length) {
                if (arr1[i1] < arr2[i2]) {
                    result[i++] = arr1[i1++];
                } else {
                    result[i++] = arr2[i2++];
                }
            } else {
                if (i1 < arr1.length) {
                    result[i++] = arr1[i1++];
                }

                if (i2 < arr2.length) {
                    result[i++] = arr2[i2++];
                }
            }
        }
        return result;
    }
    public int longestSquareStreak(int[] nums) {
        if (nums.length < 2) return -1;
        //Arrays.sort(nums);
        sortArrayByMergeSort(nums);
        List<Integer> numsList = new ArrayList<>();
        Collections.addAll(numsList, Arrays.stream(nums).boxed().toArray(Integer[]::new));
//        for(int num: nums) {
//            numsList.add(num);
//        }
        //numsList.addAll(Arrays.asList(nums));
        int count = 1;  //biến lưu trữ kết quả sau mỗi lần lặp để so sánh với maxResult
        int maxResult = 1;  //biến return kquả cao nhất
        int i = 0;  //biến index chạy từ đầu
        //int iValue = nums[i];   //giá trị tại biến index
        return recursion(numsList, i, count, maxResult);
    }
    //2 3 4 6 8 16
    //2 3 6 9 16
    public int recursion(List<Integer> numsList, int i, int count, int maxResult) {
        //if(Math.pow(numsList.get(0), 2) > numsList.get(numsList.size() - 1)) return - 1;
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
        int iValue = numsList.get(i);
        count = 1; //sau mỗi lần đệ quy, thì count sẽ quay về 1
        int square = (int) Math.pow(iValue, 2);     //biến tính bình phương tại index i
        for(int j = i + 1; j < numsList.size(); ) {
            if (numsList.get(i) == numsList.get(j)) {
                numsList.remove(j);
                continue;
            }
            if (square == numsList.get(j)) {
                iValue = numsList.get(j);
                square = (int) Math.pow(iValue, 2);
                numsList.remove(j);
                count++;
            }
            else j++;
        }
        //i++;
        return recursion(numsList, i + 1, count, maxResult);
    }
}
