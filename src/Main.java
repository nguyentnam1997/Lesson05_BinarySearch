public class Main {
    public static void main(String[] args) {
        //int[] nums = new int[] {0,1};
        Solution solution = new Solution();
//        int[] arr1 = new int[] {-3,-3,4,-1,-10};
//        int[] arr2 = new int[] {7,10};
//        System.out.println(solution.findTheDistanceValue(arr1, arr2, 12));
        int[] nums = new int[] {6,8,3,1,7,5};

        System.out.println(solution.longestSquareStreak(nums));
    }
}