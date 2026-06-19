import java.util.*;

class SubsetSum1 {
    public static void main(String[] args) {
        var nums = new int[] {3,1,2};
        var ans = new ArrayList<Integer>();

        subsetSum1(0, 0, nums, ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    public static void subsetSum1(int index, int sum, int[] arr, ArrayList<Integer> list) {
        if(index == arr.length) {
            list.add(sum);
            return;
        }

        subsetSum1(index + 1, sum + arr[index], arr, list);
        subsetSum1(index + 1, sum, arr, list);
    }
}