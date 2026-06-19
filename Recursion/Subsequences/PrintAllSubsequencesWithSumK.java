import java.util.*;

class PrintAllSubsequencesWithSumK {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int targetSum = 3;
        printSubsequences(arr, new ArrayList<Integer>(), 0, 0, targetSum);
    }

    public static void printSubsequences(int[] arr, ArrayList<Integer> list, int index, int sum , int target) {
        if(index >= arr.length) { return; }

        list.add(arr[index]);
        if(arr[index] + sum == target) { System.out.println(list); }
        printSubsequences(arr, list, index + 1, sum + arr[index], target);

        list.removeLast();
        printSubsequences(arr, list, index + 1, sum, target);
    }
}