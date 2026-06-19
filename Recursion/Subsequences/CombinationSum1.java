import java.util.*;

class CombinationSum1 {
    public static void main(String[] args) {
        var arr = new int[]{2, 3, 6, 7};
        var ans = new ArrayList<ArrayList<Integer>>();
        combinationSum1(0, 7, arr, new ArrayList<Integer>(), ans);
        System.out.println(ans);
    }

    public static void combinationSum1(int index, int sum, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if(index == arr.length) {
            if (sum == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[index] <= sum) {
            list.add(arr[index]);
            combinationSum1(index, sum - arr[index], arr, list, ans);
            list.removeLast();
        }
        combinationSum1(index + 1, sum, arr, list, ans);
    }
}