import java.util.*;

class CombinationSum2 {
    public static void main(String[] args) {
        var candidates = new int[] {10,1,2,7,6,1,5};
        Arrays.sort(candidates);
        var ans = new ArrayList<ArrayList<Integer>>();

        combinationSum2(0, 8, candidates, new ArrayList<Integer>(), ans);
        System.out.println(ans);

        var candidates2 = new int[] {2,5,2,1,2};
        Arrays.sort(candidates2);
        var ans2 = new ArrayList<ArrayList<Integer>>();

        combinationSum2(0, 5, candidates2, new ArrayList<Integer>(), ans2);
        System.out.println(ans2);
    }

    public static void combinationSum2(int index, int sum, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if(sum == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < arr.length; i ++) {
            if(i > index && arr[i] == arr[i - 1]) continue;
            if(arr[i] > sum) return;

            list.add(arr[i]);
            combinationSum2(i + 1, sum - arr[i], arr, list, ans);
            list.removeLast();
        }
    }
}