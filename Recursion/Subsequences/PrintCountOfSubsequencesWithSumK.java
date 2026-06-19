import java.util.*;

class PrintCountOfSubsequencesWithSumK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int k = 4;
        System.out.println(printCountOfSubsequencesWithSumK(arr, new ArrayList<Integer>(), 0, 0, k));
    }

    public static int printCountOfSubsequencesWithSumK(int[] arr, ArrayList<Integer> list, int index, int sum, int k) {
        if(index >= arr.length) { return 0; }

        int count = 0;
        list.add(arr[index]);
        if(sum + arr[index] == k) { count  = 1; }
        count += printCountOfSubsequencesWithSumK(arr, list, index + 1, sum + arr[index], k);
        count += printCountOfSubsequencesWithSumK(arr, list, index + 1, sum, k);

        return count;
    }
}