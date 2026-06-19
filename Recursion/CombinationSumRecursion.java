import java.util.*;

class CombinationSumRecursion {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        Arrays.sort(arr);
        int target = 7;
        printSubsequencesThatAddUptoTarget(arr, 0 , 0 , target, new ArrayList<Integer>());
    }

    public static void printSubsequencesThatAddUptoTarget(int[] arr, int index , int sum, int k, ArrayList<Integer> list) {
        if(index >= arr.length) { return; }

        if(k - sum < arr[index]) { return; }
        if(k - sum == 0) { System.out.println(list); }

        list.add(arr[index]);
        printSubsequencesThatAddUptoTarget(arr, index, sum + arr[index], k, list);

        list.removeLast();
        printSubsequencesThatAddUptoTarget(arr, index + 1, sum, k, list);
    }
}


