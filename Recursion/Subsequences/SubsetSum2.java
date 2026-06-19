import java.util.*;

class SubsetSum2 {
    public static void main(String[] args) {
        var arr = new int[] {2, 1, 2};
        var ans = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(arr);

        subsetSum2(0, arr, new ArrayList<Integer>(), ans);
        System.out.println(ans);
    }

    public static void subsetSum2(int index, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for(int i = index; i < arr.length; i++) {
            if(i > index && arr[i] == arr[i - 1]) continue;

            list.add(arr[i]);
            subsetSum2(i + 1, arr, list, ans);
            list.removeLast();
        }
    }
}